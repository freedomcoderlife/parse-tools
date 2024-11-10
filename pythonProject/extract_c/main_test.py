import re
import os

def extract_functions_from_c(file_path):
    with open(file_path, 'r') as file:
        code = file.read()

    # 正则表达式匹配 C 函数定义
    function_pattern = re.compile(
        r'(\w[\w\s\*]+)\s+(\w+)\s*\(([^)]*)\)\s*{', re.MULTILINE
    )

    # 用于存储函数名称和代码
    functions = {}

    # 查找所有函数定义
    matches = function_pattern.finditer(code)
    for match in matches:
        return_type = match.group(1).strip()  # 返回类型
        func_name = match.group(2).strip()  # 函数名称
        params = match.group(3).strip()  # 参数列表
        print(func_name)

        # 从函数定义开始，找到匹配的结束大括号
        func_body = extract_function_body(code, match.start())
        functions[func_name] = func_body

    return functions

c_keywords = {
    "auto", "break", "case", "char", "const", "continue", "default",
    "do", "double", "else", "enum", "extern", "float", "for", "goto",
    "if", "inline", "int", "long", "register", "restrict", "return",
    "short", "signed", "sizeof", "static", "struct", "switch", "typedef",
    "union", "unsigned", "void", "volatile", "while"
}



def is_valid_identifier(identifier):
    # 正则表达式规则
    pattern = r'^[a-zA-Z_][a-zA-Z0-9_]*$'
    return  re.match(pattern, identifier.strip()) is not None and identifier.strip() not in c_keywords

c_key_char = {
  "=","(", ")", "!", ",", ";",
}


def extrace_token(func_body):
    tokens = []
    current = ''
    for char in func_body:
        if char in c_key_char:
            if len(current.strip()) > 0:
                tokens.append(current.strip())
            tokens.append(char)
            current = ''
        elif char == '\t' or char == ' ' or char == '\n':
            if len(current.strip()) > 0 :
                tokens.append(current.strip())
                current = ''
        else:
            current = current + char
    for i in tokens:
        print(i)
    return tokens


def extract_calls3(func_body):
    calls = []
    stack = []
    func_name = ''
    args = []
    tokens = extrace_token(func_body)
    for i in range(len(tokens) - 1):
        if i > 0 and tokens[i] == '(' and is_valid_identifier(tokens[i-1]):
            stack.append(tokens[i-1])
            stack.append(tokens[i])
        elif len(stack) > 0 and tokens[i] != ')':
            stack.append(tokens[i])
        elif len(stack) > 0 and tokens[i] == ')':
            while stack:
                current = stack.pop()
                if current == '(':
                    func_name = stack.pop()
                    calls.append((func_name, ''.join(args[::-1])))
                    args=[]
                    break
                else:
                    args.append(current)
    return calls






def extract_calls2(func_body):
    calls = []
    stack = []
    func_name = ''
    args = ''
    # func_body = '''
    # {
    #     u8 *shadow = (u8 *)kasan_mem_to_shadow(addr);
    #     pr_err("Pointer tag: [%02x], memory tag: [%02x]\n", addr_tag, *shadow);
    # }
    # '''
    in_call = False
    brace_index = func_body.find('{')
    for char in func_body[brace_index + 1:]:
        if char == '(':
            # print(func_name)
            # print(is_valid_identifier(func_name))
            if is_valid_identifier(func_name) is False:
                func_name = ''
                stack.clear()
                continue
            stack.append(func_name)
            # if in_call:
            #     stack.append(func_name)
            #     func_name = ''
            in_call = True
            args = ''
        elif char == ')':
            if in_call is False:
                func_name = ''
                stack.clear()
                continue
            if stack:
                last_func = stack.pop()
                calls.append((last_func, args.strip()))
                in_call = False
                func_name = ''
                args = ''
        elif char == ',' and in_call:
            args += ','
        else:
            if in_call:
                args += char
            else:
                # 可能是函数名的字符 or char == ' ' or char == '\t'
                if char.isalnum() or char == '_':
                    func_name += char
                # else:
                # func_name += char
    return calls

def extract_function_body(code, start_index):
    # 维护一个栈以处理嵌套的大括号
    stack = []
    body = []
    in_function = False

    for i in range(start_index, len(code)):
        char = code[i]
        if char == '{':
            if not in_function:
                in_function = True
            stack.append(char)
        elif char == '}':
            if stack:
                stack.pop()
            if not stack:  # 栈为空，函数体结束
                body.append('}')
                break
        if in_function:
            body.append(char)

    return ''.join(body)


def extract_calls(func_body):
    calls = []
    call_pattern = re.compile(r'(\w+)\s*\(([^)]*)\)')  # 匹配函数调用

    # 查找所有函数调用
    for line in func_body.splitlines():
        line = line.strip()
        match = call_pattern.search(line)
        if match:
            func_name = match.group(1)
            arguments = match.group(2).strip()
            calls.append((func_name, arguments))

    return calls

def extrace_single_c_file(file_path):
    print("file_path================%s======start==================\n"%file_path)
    functions = extract_functions_from_c(file_path)

    # 输出每个函数的完整代码
    for func_name, func_code in functions.items():
        print(f"====================================================\n")
        print(f"Function: {func_name}\nCode:\n{func_code}\n")

        calls = extract_calls2(func_code)
        if calls:
            print("Function Calls:")
            for call in calls:
                print(f"  Called Function: {call[0]}, Arguments: {call[1]}")
        else:
            print("No Function Calls")
        print(f"====================================================\n")
    print("file_path================%s===end=====================\n"%file_path)

def find_c_files(directory):
    c_files = []
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith('.c'):
                c_files.append(os.path.join(root, file))
    return c_files
def parse_c_dir(directory):
    c_files = find_c_files(directory)

    # 输出找到的 .c 文件
    for c_file in c_files:
        extrace_single_c_file(c_file)


# 主函数
if __name__ == "__main__":
    func_body = '''
    
    {
	const char *sep = strchr(*frame_descr, ' ');

	if (sep == NULL)
		sep = *frame_descr + strlen(*frame_descr);

	if (token != NULL) {
		const size_t tok_len = sep - *frame_descr;

		if (tok_len + 1 > max_tok_len) {
			pr_err("KASAN internal error: frame description too long: %s\n",
			       *frame_descr);
			return false;
		}

		/* Copy token (+ 1 byte for '\0'). */
		strlcpy(token, *frame_descr, tok_len + 1);
	}

	/* Advance frame_descr past separator. */
	*frame_descr = sep + 1;

	if (value != NULL && kstrtoul(token, 10, value)) {
		pr_err("KASAN internal error: not a valid number: %s\n", token);
		return false;
	}

	return true;
}
    
    '''
    calls = extract_calls3(func_body)
    if calls:
        print("Function Calls:")
        for call in calls:
            print(f"  Called Function: {call[0]}, Arguments: {call[1]}")

    # directory = '/home/liming/code/c/opensrc/linux-5.4.34/mm/'  # 替换为你要搜索的目录路径
    # parse_c_dir(directory)

    # calls = extract_calls2(directory)
    # if calls:
    #     print("Function Calls:")
    #     for call in calls:
    #         print(f"  Called Function: {call[0]}, Arguments: {call[1]}")
    # else:
    #     print("No Function Calls")
# 使用示例

# def extract_functions_from_c_file(file_path):
#     # 正则表达式匹配 C 语言函数
#     function_pattern = r'(\w[\w\s\*]+)\s+(\w+)\s*\(([^)]*)\)'
#
#     with open(file_path, 'r', encoding='utf-8') as file:
#         content = file.read()
#         matches = re.findall(function_pattern, content)
#
#         return matches
#
#
# def traverse_directory_and_extract_functions(directory):
#     all_functions = {}
#
#     for root, dirs, files in os.walk(directory):
#         for file in files:
#             if file.endswith('.c'):
#                 file_path = os.path.join(root, file)
#                 functions = extract_functions_from_c_file(file_path)
#                 if functions:
#                     all_functions[file_path] = functions
#
#     return all_functions
#
#
# # 使用示例
# directory_path = '/home/liming/code/c/opensrc/linux-5.4.34/mm'  # 替换为你的目录路径
# functions_found = traverse_directory_and_extract_functions(directory_path)
#
# # 打印提取的函数信息
# for file_path, functions in functions_found.items():
#     print(f'File: {file_path}')
#     for return_type, function_name, parameters in functions:
#         print(f'  Return Type: {return_type}, Function Name: {function_name}, Parameters: {parameters}')
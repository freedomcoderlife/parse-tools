import pdfplumber

import re
import json
import pandas as pd


def extrace_key_word(pattern, text):
    matches = re.findall(pattern, text)
    for match in matches:
        return match

def extrace_company_info(pdf):
    company_code_pattern = r'公司代码：([0-9]+)'
    company_name_abbreviation_pattern = r'公司简称：(.*)'
    company_full_name_pattern=r'.*股份有限公司'
    first_page = pdf.pages[0]
    first_text = first_page.extract_text()
    company_code = extrace_key_word(company_code_pattern, first_text)
    company_name_abbreviation = extrace_key_word(company_name_abbreviation_pattern, first_text)
    company_full_name = extrace_key_word(company_full_name_pattern, first_text)
    print(company_code)
    print(company_name_abbreviation)
    print(company_full_name)

def extract_table_name(pdf):
    pages = pdf.pages
    first_page = pdf.pages[28]
    # text = first_page.extract_text()
    # print(text)
    # 提取表格
    tables = first_page.find_tables()
    table = tables[0]
    print(table.cells[0][1])

    words = first_page.extract_words()
    for i in range(len(words)):
        word_top = words[i].get('top')
        if (i + 1 < len(words)):
            next_top = words[i+1].get('top')
            print(words[i])
            if table.cells[0][1] > word_top and table.cells[0][1] <= next_top:
                print(words[i])
                print('表名为%s'% words[i].get('text'))

# 查找开始页码
def find_report_page(pages, keywords):
    for index, page in enumerate(pages):
        words = page.extract_words()
        for i, word in enumerate(words):
            # print(word)
            if keywords == word['text']:
                print("find page num %s" % index)
                return index
            if i + 1 < len(words):
                concat_contents = word['text'] + words[i+1]['text']
                print(concat_contents)
                if keywords == concat_contents:
                    print("find concat page num %s" % index)
                    return index

def parse_content(page):
    contents_text = page.extract_text()
    contents_lines = contents_text.splitlines()
    result_dict = {}
    for line in contents_lines:
        if '...' in line:
            items = re.split(r'[\.]+', line)
            key = re.split('\s+', items[0].strip())
            result_dict[key[1].strip()] = int(items[1].strip())
    return result_dict

def extract_content_report_page(lines):
    for line in lines:
        if '财务报告' in line:
            items = re.split(r'[\.]+', line)
            for i in items:
                print(i)
            # print(line)
            match = re.search(r'\d+', line)
            if match:
                number = match.group(0)  # 提取匹配的数字
                print(f"提取的数字是: {number}")
            else:
                pass

'''
 可以通过填充None，为左边的值，实现整理表头
'''

def extract_table_header():
    pass

def extract_report(path):
    with pdfplumber.open(path) as pdf:
        pages = pdf.pages
        content_num = find_report_page(pages, '目录')

        contents_dict = parse_content(pages[content_num])
        print(contents_dict)
        start_page_num = contents_dict['财务报告'] - 1
        print('start number %s' % start_page_num )

        #start_page_num = find_report_page(pages, '合并资产负债表')
        search_page = pages[start_page_num:]

        end_page_num = find_report_page(search_page, '合并所有者权益变动表')
        end_page_num = end_page_num + start_page_num
        report_pages = pdf.pages[start_page_num:end_page_num]
        df = None
        columns_name = []
        for report in report_pages:
            all_tables= []
            tables = report.extract_tables()
            for table in tables:
                # print(table)
                # 将表格转换为 DataFrame
                first_rows_name = table[0]
                # print(first_rows_name)
                if '项目' in first_rows_name:
                    columns_name = first_rows_name
                    # print(columns_name)
                    if df is not None:
                        print(df.to_json(orient='records', force_ascii=False, indent=4))
                        df = None
                    df = pd.DataFrame(table[1:], columns=columns_name)
                else:
                    df2 = pd.DataFrame(table, columns=columns_name)
                    df = df.append(df2)

        if df is not None:
            print(df.to_json(orient='records', force_ascii=False, indent=4))

path = '/home/liming/code/python/pythonProject/report/600012_20240831_HJQM.pdf'
# extract_report(path)

def extract_basic_info(path):
    with pdfplumber.open(path) as pdf:
        pages = pdf.pages
        content_num = find_report_page(pages, '目录')
        print('================', content_num)
        contents_dict = parse_content(pages[content_num])
        print(contents_dict)
        start_page_num = contents_dict['公司简介和主要财务指标'] - 1
        print('start number %s' % start_page_num )
        pages = pages[start_page_num:]
        for page in pages:
            tables = page.extract_tables()
            for table in tables:
                table = list(zip(*table))
                df = pd.DataFrame(table[1:], columns=table[0])
                print(df.to_json(orient='records', force_ascii=False, indent=4))
                break
            break
extract_basic_info(path)




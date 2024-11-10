import pdfplumber
import pandas as pd

pdf_file = "/home/liming/code/python/pythonProject/report/report.pdf"
tables=[]
with pdfplumber.open(pdf_file) as pdf:
    pages = pdf.pages
    for i in pages:
        print(i.extract_text())
    page = pages[1]
    text = page.extract_text()
    print(text)
    tl = page.extract_table()
    print(tl)
    df = pd.DataFrame(tl)
    # 行数
    print(df.shape[0])
    # 列数
    print(df.shape[1])
    # first_column = df.iloc[:, 0]
    # print(type(first_column))
    # print(first_column)
    # first_row = df.iloc[0, :]
    # print(first_row)
    for i in range(1,df.shape[1]):
        record = {"year": df.iloc[0,i]}
        for j in range(1,df.shape[0]):
            record[df.iloc[j,0]] = df.iloc[j,i]
        print(record)



    # for index, row in df.iteritems():
    #     for i in range(len(row)):
    #         print('%s %s' % (index, row[i]))


    #
    # print(df.to_json(orient = 'table', force_ascii = False))
    # first_column = df.iloc[:, 0]
    # for i in first_column:
    #     df.

    # for i,pg in enumerate(pages):
    #     tbl = pages[i].extract_table()
    #     df = pd.DataFrame(tbl)
    #     print(f'{df}')

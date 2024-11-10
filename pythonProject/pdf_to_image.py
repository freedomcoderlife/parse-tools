
from pdf2image import convert_from_path

# 指定 PDF 文件路径
pdf_path = 'rep.pdf'  # 替换为你的 PDF 文件路径

# 将 PDF 转换为图像
images = convert_from_path(pdf_path)

# 保存每一页为 JPEG 图片
for i, image in enumerate(images):
    image.save(f'page_{i + 1}.jpeg', 'JPEG')

print(f"已成功将 {pdf_path} 转换为 JPEG 图片。")
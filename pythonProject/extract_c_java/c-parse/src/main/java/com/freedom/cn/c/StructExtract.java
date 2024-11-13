package com.freedom.cn.c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StructExtract {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STRING_LENGTH = 20;

    public static void main(String[] args) {
        String filePath = "/home/liming/code/c/opensrc/linux-5.4.34/include/rdma/ib_cm.h"; // 替换为你的C文件路径
        convertStructsToDrawio(filePath);
    }





    public static String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(STRING_LENGTH);

        for (int i = 0; i < STRING_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }

    public static void convertStructsToDrawio(String filePath) {
        String commentPattern = "(//.*?$)|(/\\*.*?\\*/)";
        String structPattern = "struct\\s+(\\w+)\\s*\\{([^}]*)\\};";
        Pattern commentRegex = Pattern.compile(commentPattern, Pattern.DOTALL | Pattern.MULTILINE);
        Pattern structRegex = Pattern.compile(structPattern, Pattern.DOTALL);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // 去掉注释
            String cleanedContent = commentRegex.matcher(content.toString()).replaceAll("").trim();

            String formatPosition = "\t\t\t<mxGeometry x=\"%s\" y=\"%s\" width=\"120\" height=\"80\" as=\"geometry\"/>\n";
            String structFormat ="\t\t<mxCell id=\"%s\" value=\"%s\" style=\"swimlane;fontStyle=1;align=center;verticalAlign=top;childLayout=stackLayout;horizontal=1;startSize=26;horizontalStack=0;resizeParent=1;resizeParentMax=0;resizeLast=0;collapsible=1;marginBottom=0;\" parent=\"%s\" vertex=\"1\">\n";
            String cellEndMark = "        </mxCell>\n";

            String fieldFormat = "        <mxCell id=\"%s\" value=\"%s : %s\" style=\"text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;\" vertex=\"1\" parent=\"%s\">\n";

            String fieldPostionFormat = "          <mxGeometry y=\"%s\" width=\"160\" height=\"%s\" as=\"geometry\" />\n";
            int fieldHigth= 30;
            int fieldY = 30;

            // 开始构建Draw.io XML
            StringBuilder drawioXML = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            drawioXML.append("<mxfile userAgent=\"Electron\">\n");
            drawioXML.append("  <diagram name=\"Page-1\" id=\"diagramId\">\n");
            drawioXML.append("    <mxGraphModel dx=\"1104\" dy=\"649\" grid=\"1\" gridSize=\"10\" guides=\"1\" tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\" pageScale=\"1\" pageWidth=\"827\" pageHeight=\"1169\" math=\"0\" shadow=\"0\">\n");
            drawioXML.append("      <root>\n");
            drawioXML.append("        <mxCell id=\"RSFqor3WkNCXx0AEMyML-0\" />\n");
            drawioXML.append("        <mxCell id=\"RSFqor3WkNCXx0AEMyML-1\" parent=\"RSFqor3WkNCXx0AEMyML-0\" />\n");
            // 匹配结构体并生成mxCell
            Matcher matcher = structRegex.matcher(cleanedContent);


            int x = 100;
            int y = 100;

            while (matcher.find()) {

                int id = 0;  // 用于唯一标识每个结构体
                String structIdPrefix = generateRandomString() + "-";
                String structName = matcher.group(1);
                String structBody = matcher.group(2).trim();
                // Postition
                x = x + 100;
                String onePostition = String.format(formatPosition, x, y);

                // 添加结构体作为mxCell
                String structCeil = String.format(structFormat,structIdPrefix+id,structName,"RSFqor3WkNCXx0AEMyML-1");
                drawioXML.append(structCeil);
                drawioXML.append(onePostition);
                drawioXML.append(cellEndMark);

                System.out.println("=================" + structBody);
                // 处理结构体体内的字段
                String[] fields = structBody.split(";");
                id++;
                int fieldNum = 0;
                for (String field : fields) {
                    field = field.trim();
                    if (!field.isEmpty()) {
                        // 假设字段格式为 "类型 名称"
                        String[] parts = field.split("\\s+", 2);
                        if (parts.length == 2) {
                            // 添加字段作为mxCell
                            String fieldXmlNode = String.format(fieldFormat, structIdPrefix + id, parts[1], parts[0], structIdPrefix + 0);
                            drawioXML.append(fieldXmlNode);
                            String oneFieldPostion = String.format(fieldPostionFormat, fieldY + fieldNum * fieldHigth, fieldHigth);
                            drawioXML.append(oneFieldPostion);
                            drawioXML.append(cellEndMark);
                            fieldNum++;
                            id++;
                        }
                    }
                }
                id=0;  // 为下一个结构体留出ID
            }

            drawioXML.append("      </root>\n");
            drawioXML.append("    </mxGraphModel>\n");
            drawioXML.append("  </diagram>\n");
            drawioXML.append("</mxfile>");

            System.out.println(drawioXML.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void convertStructsToDot(String filePath) {
        String commentPattern = "(//.*?$)|(/\\*.*?\\*/)";
        String structPattern = "struct\\s+(\\w+)\\s*\\{([^}]*)\\};";
        Pattern commentRegex = Pattern.compile(commentPattern, Pattern.DOTALL | Pattern.MULTILINE);
        Pattern structRegex = Pattern.compile(structPattern, Pattern.DOTALL);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // 去掉注释
            String cleanedContent = commentRegex.matcher(content.toString()).replaceAll("").trim();

            // 开始构建DOT格式
            StringBuilder dotOutput = new StringBuilder("digraph Structs {\n");
            dotOutput.append("  node [shape=record];\n");

            // 匹配结构体
            Matcher matcher = structRegex.matcher(cleanedContent);
            while (matcher.find()) {
                String structName = matcher.group(1);
                String structBody = matcher.group(2).trim();

                dotOutput.append("  ").append(structName).append(" [label=\"{").append(structName).append("|");

                // 处理结构体体内的字段
                String[] fields = structBody.split(";");
                for (String field : fields) {
                    field = field.trim();
                    if (!field.isEmpty()) {
                        // 假设字段格式为 "类型 名称"
                        String[] parts = field.split("\\s+", 2);
                        if (parts.length == 2) {
                            dotOutput.append(parts[1]).append(" : ").append(parts[0]).append("|");
                        }
                    }
                }
                // 移除最后一个竖线
                if (dotOutput.charAt(dotOutput.length() - 1) == '|') {
                    dotOutput.setLength(dotOutput.length() - 1);
                }
                dotOutput.append("}\" ];\n");
            }

            dotOutput.append("}\n");
            System.out.println(dotOutput.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void convertStructsToDrawioClassDiagram(String filePath) {
        String commentPattern = "(//.*?$)|(/\\*.*?\\*/)";
        String structPattern = "struct\\s+(\\w+)\\s*\\{([^}]*)\\};";
        Pattern commentRegex = Pattern.compile(commentPattern, Pattern.DOTALL | Pattern.MULTILINE);
        Pattern structRegex = Pattern.compile(structPattern, Pattern.DOTALL);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // 去掉注释
            String cleanedContent = commentRegex.matcher(content.toString()).replaceAll("").trim();

            // 开始构建Draw.io类图XML
            StringBuilder drawioXML = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            drawioXML.append("<mxfile userAgent=\"Mozilla/5.0\">\n");
            drawioXML.append("  <diagram name=\"Class Diagram\" id=\"diagramId\">\n");
            drawioXML.append("    <mxGraphModel dx=\"827\" dy=\"529\" grid=\"1\" gridSize=\"10\" guides=\"1\" tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\" pageScale=\"1\" pageWidth=\"827\" pageHeight=\"1169\" math=\"0\" shadow=\"0\">\n");
            drawioXML.append("      <root>\n");
            drawioXML.append("        <mxCell id=\"0\" parent=\"1\"/>\n");
            drawioXML.append("        <mxCell id=\"1\" parent=\"1\"/>\n");

            // 匹配结构体
            Matcher matcher = structRegex.matcher(cleanedContent);
            int id = 2;  // 用于唯一标识每个结构体

            while (matcher.find()) {
                String structName = matcher.group(1);
                String structBody = matcher.group(2).trim();

                // 添加结构体作为一个类
                drawioXML.append("        <mxCell id=\"").append(id).append("\" value=\"").append(structName).append("\" style=\"rounded=1;whiteSpace=wrap;html=1;\" vertex=\"1\" parent=\"1\">\n");
                drawioXML.append("          <mxGeometry width=\"120\" height=\"80\" as=\"geometry\"/>\n");
                drawioXML.append("        </mxCell>\n");

                // 处理结构体体内的字段
                String[] fields = structBody.split(";");
                for (String field : fields) {
                    field = field.trim();
                    if (!field.isEmpty()) {
                        // 假设字段格式为 "类型 名称"
                        String[] parts = field.split("\\s+", 2);
                        if (parts.length == 2) {
                            // 添加字段作为类的属性
                            drawioXML.append("        <mxCell id=\"").append(id + 1).append("\" value=\"").append(parts[1]).append(" : ").append(parts[0]).append("\" style=\"text;html=1;\" vertex=\"1\" parent=\"1\">\n");
                            drawioXML.append("          <mxGeometry width=\"120\" height=\"30\" as=\"geometry\"/>\n");
                            drawioXML.append("        </mxCell>\n");
                            id++;
                        }
                    }
                }
                id++;  // 为下一个结构体留出ID
            }

            drawioXML.append("      </root>\n");
            drawioXML.append("    </mxGraphModel>\n");
            drawioXML.append("  </diagram>\n");
            drawioXML.append("</mxfile>");

            System.out.println(drawioXML.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void convertStructsToPlantUML(String filePath) {
        String commentPattern = "(//.*?$)|(/\\*.*?\\*/)";
        String structPattern = "struct\\s+(\\w+)\\s*\\{([^}]*)\\};";
        Pattern commentRegex = Pattern.compile(commentPattern, Pattern.DOTALL | Pattern.MULTILINE);
        Pattern structRegex = Pattern.compile(structPattern, Pattern.DOTALL);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // 去掉注释
            String cleanedContent = commentRegex.matcher(content.toString()).replaceAll("").trim();

            // 开始构建PlantUML
            StringBuilder plantUML = new StringBuilder("@startuml\n");

            // 匹配结构体
            Matcher matcher = structRegex.matcher(cleanedContent);
            while (matcher.find()) {
                String structName = matcher.group(1);
                String structBody = matcher.group(2).trim();
                plantUML.append("class ").append(structName).append(" {\n");

                // 处理结构体体内的字段
                String[] fields = structBody.split(";");
                for (String field : fields) {
                    field = field.trim();
                    if (!field.isEmpty()) {
                        // 假设字段格式为 "类型 名称"
                        String[] parts = field.split("\\s+", 2);
                        if (parts.length == 2) {
                            plantUML.append("  ").append(parts[0]).append(" ").append(parts[1]).append("\n");
                        }
                    }
                }
                plantUML.append("}\n\n");
            }

            plantUML.append("@enduml");
            System.out.println(plantUML.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

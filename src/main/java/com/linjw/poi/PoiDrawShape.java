package com.linjw.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFShapeTypes;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 直线在sheet中位置 new HSSFClientAnchor(x1, y1, x2, y2, (short)startcol, startrow,
 * (short)endcol, endrow)
 * 
 * @param x1
 *            直线一端在开始单元格(startcol, startrow)内的横坐标，范围[0, 2013],将列宽均分为1023份
 * @param y1
 *            直线一端在开始单元格(startcol, startrow)内的纵坐标，范围[0, 255],将行高均分为255份
 * @param x2
 *            直线一端在结束单元格(endcol, endrow)内的横坐标，范围[0, 2013],将列宽均分为1023份
 * @param y2
 *            直线一端在结束单元格(endcol, endrow)内的纵坐标，范围[0, 255],将列宽均分为255份
 * @param startcol
 *            直线一端所处开始列号，base 0
 * @param startrow
 *            直线一端所处开始行号，base 0
 * @param endcol
 *            直线另一端所处结束列号，base 0
 * @param endrow
 *            直线另一端所处结束行号，base 0
 */
public class PoiDrawShape {

	public static void main(String[] args) throws Exception {
		// 创建一个工作博
		Workbook workbook = new HSSFWorkbook();
		// 创建一个sheet
		Sheet sheet = workbook.createSheet();
		// 画图的顶级管理器对象HSSFPatriarch, 一个sheet只能获取一个
		HSSFPatriarch hssfPatriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();

		HSSFClientAnchor anchor1 = new HSSFClientAnchor(0, 0, 0, 0, (short) 1, 2, (short) 3, 10);
		// 没有图形
		HSSFSimpleShape notPrimitive = hssfPatriarch.createSimpleShape(anchor1);
		notPrimitive.setShapeType(HSSFShapeTypes.NotPrimitive);

		HSSFClientAnchor anchor2 = new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 3, (short) 6, 10);
		// 创建一个没有填充色的矩形
		HSSFSimpleShape rect = hssfPatriarch.createSimpleShape(anchor2);
		rect.setShapeType(HSSFShapeTypes.Rectangle);
		rect.setNoFill(true);

		HSSFClientAnchor anchor3 = new HSSFClientAnchor(0, 0, 0, 0, (short) 7, 2, (short) 9, 4);
		// 创建一个圆角矩形
		HSSFSimpleShape roundRectangle = hssfPatriarch.createSimpleShape(anchor3);
		roundRectangle.setShapeType(HSSFShapeTypes.RoundRectangle);
		//roundRectangle.setLineStyle(HSSFShape.LINESTYLE_DOTSYS);
		roundRectangle.setLineWidth(25400);
		HSSFRichTextString ts = new HSSFRichTextString("Write things here");
		HSSFFont greenFont = (HSSFFont) workbook.createFont();
		greenFont.setColor(HSSFColor.GREEN.index);
		HSSFFont red = (HSSFFont) workbook.createFont();
		red.setColor(HSSFColor.RED.index);
		ts.applyFont(0, 5, greenFont);
		ts.applyFont(6, 11, red);
		roundRectangle.setString(ts);
		
		HSSFClientAnchor anchor3_1 = new HSSFClientAnchor(0, 0, 0, 0, (short) 7, 5, (short) 9, 7);
		// 创建一个圆角矩形
		HSSFSimpleShape roundRectangle_1 = hssfPatriarch.createSimpleShape(anchor3_1);
		roundRectangle_1.setShapeType(HSSFShapeTypes.RoundRectangle);
		
		HSSFClientAnchor anchor3_2 = new HSSFClientAnchor(0, 0, 0, 0, (short) 7, 8, (short) 9, 10);
		// 创建一个圆角矩形
		HSSFSimpleShape roundRectangle_2 = hssfPatriarch.createSimpleShape(anchor3_2);
		roundRectangle_2.setShapeType(HSSFShapeTypes.RoundRectangle);

		HSSFClientAnchor anchor4 = new HSSFClientAnchor(0, 0, 0, 0, (short) 10, 2, (short) 12, 10);
		// 创建一个椭圆
		HSSFSimpleShape ellipse = hssfPatriarch.createSimpleShape(anchor4);
		ellipse.setShapeType(HSSFShapeTypes.Ellipse);

		HSSFClientAnchor anchor5 = new HSSFClientAnchor(0, 0, 0, 0, (short) 13, 2, (short) 15, 10);
		// 创建一个菱形
		HSSFSimpleShape diamond = hssfPatriarch.createSimpleShape(anchor5);
		diamond.setShapeType(HSSFShapeTypes.Diamond);

		HSSFClientAnchor anchor6 = new HSSFClientAnchor(0, 0, 0, 0, (short) 16, 2, (short) 18, 10);
		// 创建一个等腰三角形
		HSSFSimpleShape isocelesTriangle = hssfPatriarch.createSimpleShape(anchor6);
		isocelesTriangle.setShapeType(HSSFShapeTypes.IsocelesTriangle);

		HSSFClientAnchor anchor21 = new HSSFClientAnchor(0, 0, 0, 0, (short) 1, 16, (short) 3, 24);
		// 创建一个直角三角形
		HSSFSimpleShape rightTriangle = hssfPatriarch.createSimpleShape(anchor21);
		rightTriangle.setShapeType(HSSFShapeTypes.RightTriangle);

		HSSFClientAnchor anchor22 = new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 16, (short) 6, 24);
		// 创建一个平行四边形
		HSSFSimpleShape parallelogram = hssfPatriarch.createSimpleShape(anchor22);
		parallelogram.setShapeType(HSSFShapeTypes.Parallelogram);

		// HSSFClientAnchor anchor23 = new HSSFClientAnchor(0, 0, 0, 0, (short)7, 16,
		// (short)9, 24);
		// // 创建一个梯形 - 不支持
		// HSSFSimpleShape trapezoid = hssfPatriarch.createSimpleShape(anchor23);
		// trapezoid.setShapeType(HSSFShapeTypes.Trapezoid);

		HSSFClientAnchor anchor24 = new HSSFClientAnchor(0, 0, 0, 0, (short) 10, 16, (short) 12, 24);
		// 创建一个六边形
		HSSFSimpleShape hexagon = hssfPatriarch.createSimpleShape(anchor24);
		hexagon.setShapeType(HSSFShapeTypes.Hexagon);

		HSSFClientAnchor anchor25 = new HSSFClientAnchor(0, 0, 0, 0, (short) 13, 16, (short) 15, 24);
		// 创建一个八边形
		HSSFSimpleShape octagon = hssfPatriarch.createSimpleShape(anchor25);
		octagon.setShapeType(HSSFShapeTypes.Octagon);

		HSSFClientAnchor anchor26 = new HSSFClientAnchor(0, 0, 0, 0, (short) 16, 16, (short) 18, 24);
		// 创建一个十字形
		HSSFSimpleShape plus = hssfPatriarch.createSimpleShape(anchor26);
		plus.setShapeType(HSSFShapeTypes.Plus);

		FileOutputStream file = new FileOutputStream("C://Users//Administrator//Desktop//test.xls");
		workbook.write(file);
		file.close();
	}

}

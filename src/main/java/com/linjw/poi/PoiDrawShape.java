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
 * ֱ����sheet��λ�� new HSSFClientAnchor(x1, y1, x2, y2, (short)startcol, startrow,
 * (short)endcol, endrow)
 * 
 * @param x1
 *            ֱ��һ���ڿ�ʼ��Ԫ��(startcol, startrow)�ڵĺ����꣬��Χ[0, 2013],���п����Ϊ1023��
 * @param y1
 *            ֱ��һ���ڿ�ʼ��Ԫ��(startcol, startrow)�ڵ������꣬��Χ[0, 255],���и߾���Ϊ255��
 * @param x2
 *            ֱ��һ���ڽ�����Ԫ��(endcol, endrow)�ڵĺ����꣬��Χ[0, 2013],���п����Ϊ1023��
 * @param y2
 *            ֱ��һ���ڽ�����Ԫ��(endcol, endrow)�ڵ������꣬��Χ[0, 255],���п����Ϊ255��
 * @param startcol
 *            ֱ��һ��������ʼ�кţ�base 0
 * @param startrow
 *            ֱ��һ��������ʼ�кţ�base 0
 * @param endcol
 *            ֱ����һ�����������кţ�base 0
 * @param endrow
 *            ֱ����һ�����������кţ�base 0
 */
public class PoiDrawShape {

	public static void main(String[] args) throws Exception {
		// ����һ��������
		Workbook workbook = new HSSFWorkbook();
		// ����һ��sheet
		Sheet sheet = workbook.createSheet();
		// ��ͼ�Ķ�������������HSSFPatriarch, һ��sheetֻ�ܻ�ȡһ��
		HSSFPatriarch hssfPatriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();

		HSSFClientAnchor anchor1 = new HSSFClientAnchor(0, 0, 0, 0, (short) 1, 2, (short) 3, 10);
		// û��ͼ��
		HSSFSimpleShape notPrimitive = hssfPatriarch.createSimpleShape(anchor1);
		notPrimitive.setShapeType(HSSFShapeTypes.NotPrimitive);

		HSSFClientAnchor anchor2 = new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 3, (short) 6, 10);
		// ����һ��û�����ɫ�ľ���
		HSSFSimpleShape rect = hssfPatriarch.createSimpleShape(anchor2);
		rect.setShapeType(HSSFShapeTypes.Rectangle);
		rect.setNoFill(true);

		HSSFClientAnchor anchor3 = new HSSFClientAnchor(0, 0, 0, 0, (short) 7, 2, (short) 9, 4);
		// ����һ��Բ�Ǿ���
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
		// ����һ��Բ�Ǿ���
		HSSFSimpleShape roundRectangle_1 = hssfPatriarch.createSimpleShape(anchor3_1);
		roundRectangle_1.setShapeType(HSSFShapeTypes.RoundRectangle);
		
		HSSFClientAnchor anchor3_2 = new HSSFClientAnchor(0, 0, 0, 0, (short) 7, 8, (short) 9, 10);
		// ����һ��Բ�Ǿ���
		HSSFSimpleShape roundRectangle_2 = hssfPatriarch.createSimpleShape(anchor3_2);
		roundRectangle_2.setShapeType(HSSFShapeTypes.RoundRectangle);

		HSSFClientAnchor anchor4 = new HSSFClientAnchor(0, 0, 0, 0, (short) 10, 2, (short) 12, 10);
		// ����һ����Բ
		HSSFSimpleShape ellipse = hssfPatriarch.createSimpleShape(anchor4);
		ellipse.setShapeType(HSSFShapeTypes.Ellipse);

		HSSFClientAnchor anchor5 = new HSSFClientAnchor(0, 0, 0, 0, (short) 13, 2, (short) 15, 10);
		// ����һ������
		HSSFSimpleShape diamond = hssfPatriarch.createSimpleShape(anchor5);
		diamond.setShapeType(HSSFShapeTypes.Diamond);

		HSSFClientAnchor anchor6 = new HSSFClientAnchor(0, 0, 0, 0, (short) 16, 2, (short) 18, 10);
		// ����һ������������
		HSSFSimpleShape isocelesTriangle = hssfPatriarch.createSimpleShape(anchor6);
		isocelesTriangle.setShapeType(HSSFShapeTypes.IsocelesTriangle);

		HSSFClientAnchor anchor21 = new HSSFClientAnchor(0, 0, 0, 0, (short) 1, 16, (short) 3, 24);
		// ����һ��ֱ��������
		HSSFSimpleShape rightTriangle = hssfPatriarch.createSimpleShape(anchor21);
		rightTriangle.setShapeType(HSSFShapeTypes.RightTriangle);

		HSSFClientAnchor anchor22 = new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 16, (short) 6, 24);
		// ����һ��ƽ���ı���
		HSSFSimpleShape parallelogram = hssfPatriarch.createSimpleShape(anchor22);
		parallelogram.setShapeType(HSSFShapeTypes.Parallelogram);

		// HSSFClientAnchor anchor23 = new HSSFClientAnchor(0, 0, 0, 0, (short)7, 16,
		// (short)9, 24);
		// // ����һ������ - ��֧��
		// HSSFSimpleShape trapezoid = hssfPatriarch.createSimpleShape(anchor23);
		// trapezoid.setShapeType(HSSFShapeTypes.Trapezoid);

		HSSFClientAnchor anchor24 = new HSSFClientAnchor(0, 0, 0, 0, (short) 10, 16, (short) 12, 24);
		// ����һ��������
		HSSFSimpleShape hexagon = hssfPatriarch.createSimpleShape(anchor24);
		hexagon.setShapeType(HSSFShapeTypes.Hexagon);

		HSSFClientAnchor anchor25 = new HSSFClientAnchor(0, 0, 0, 0, (short) 13, 16, (short) 15, 24);
		// ����һ���˱���
		HSSFSimpleShape octagon = hssfPatriarch.createSimpleShape(anchor25);
		octagon.setShapeType(HSSFShapeTypes.Octagon);

		HSSFClientAnchor anchor26 = new HSSFClientAnchor(0, 0, 0, 0, (short) 16, 16, (short) 18, 24);
		// ����һ��ʮ����
		HSSFSimpleShape plus = hssfPatriarch.createSimpleShape(anchor26);
		plus.setShapeType(HSSFShapeTypes.Plus);

		FileOutputStream file = new FileOutputStream("C://Users//Administrator//Desktop//test.xls");
		workbook.write(file);
		file.close();
	}

}

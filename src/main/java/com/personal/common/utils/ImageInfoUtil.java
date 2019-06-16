package com.personal.common.utils;

import net.coobird.thumbnailator.builders.BufferedImageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageInfoUtil {

	private static Logger log = LoggerFactory.getLogger(ImageInfoUtil.class);

	public static Integer getAngle(String type) {
		int angle = 0;
		try {
			switch (Integer.parseInt(type)) {
				case 3:
					//要进行180度旋转
					angle = 180;
					break;
				case 6:
					//要进行90度旋转
					angle = 90;
					break;
				case 8:
					//要进行-90度旋转
					angle = -90;
					break;
				default :
					angle = 0;
					break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return angle;
	}



	/**
	 * 图片旋转
	 * @param originImage 文件
	 * @param angle 旋转角度
	 * @param suffix 后缀名称
	 * @throws IOException void
	 */
	public static Map<String, Object> rotate(BufferedImage originImage, double angle, String suffix){
		Map<String, Object> resultMap = new HashMap<>();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		BufferedImage bufferedImage = null;
		try {
//			InputStream input = new FileInputStream(file);

//			BufferedImage originImage = ImageIO.read(inputStream);
			int width = originImage.getWidth();
			int height = originImage.getHeight();
			double[][] positions = new double[4][];
			positions[0] = calculatePosition(0, 0, angle);
			positions[1] = calculatePosition(width, 0, angle);
			positions[2] = calculatePosition(0, height, angle);
			positions[3] = calculatePosition(width, height, angle);
			double minX = Math.min(
					Math.min(positions[0][0], positions[1][0]),
					Math.min(positions[2][0], positions[3][0])
			);
			double maxX = Math.max(
					Math.max(positions[0][0], positions[1][0]),
					Math.max(positions[2][0], positions[3][0])
			);
			double minY = Math.min(
					Math.min(positions[0][1], positions[1][1]),
					Math.min(positions[2][1], positions[3][1])
			);
			double maxY = Math.max(
					Math.max(positions[0][1], positions[1][1]),
					Math.max(positions[2][1], positions[3][1])
			);
			int _width = (int)Math.round(maxX - minX);
			int _height = (int)Math.round(maxY - minY);
			bufferedImage = new BufferedImageBuilder(_width, _height , BufferedImage.TYPE_INT_BGR).build();

			Graphics2D g = bufferedImage.createGraphics();

			g.setRenderingHint(
					RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR
			);
			g.setRenderingHint(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON
			);
			double w = _width / 2.0;
			double h = _height / 2.0;

			g.rotate(Math.toRadians(angle), w, h);
			int centerX = (int)Math.round((_width - width) / 2.0);
			int centerY = (int)Math.round((_height - height) / 2.0);

			g.drawImage(originImage, centerX, centerY, null);
			g.dispose();

			//利用ImageIO类的write方法,将BufferedImage以png图片的数据模式写入流。
//			String fileName = file.getName();
//			String suffix = fileName.substring(fileName.indexOf(".")+1);
			ImageIO.write(bufferedImage, suffix, outputStream);

			resultMap.put("image", bufferedImage);
			resultMap.put("bytes", outputStream.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}





	private static double[] calculatePosition(double x, double y, double angle){
		angle = Math.toRadians(angle);
		double nx = (Math.cos(angle) * x) - (Math.sin(angle) * y);
		double ny = (Math.sin(angle) * x) + (Math.cos(angle) * y);
		return new double[] {nx, ny};
	}

	public static void main(String[] args) throws Exception{
//		File file = new File("/Users/hongzhen/Downloads/1923327571.jpg");
//
//		String is = encodeImageToBase64(file);
//		stringToImage(is, "jpg");
//
//		Thumbnails.of("/Users/hongzhen/Downloads/1923327575.jpg")
////				.rotate(90)//旋转度数
//				.scale(1)//缩放比例
//				.toFile("/Users/hongzhen/Downloads/1923327575.jpg");
//
//
//		BufferedImage image = ImageIO.read(new File("/Users/hongzhen/Downloads/1923327572.jpg"));
//		System.out.println("width:"+image.getWidth());
//		image = ImageIO.read(new File("/Users/hongzhen/Downloads/1923327573.jpg"));
//		System.out.println("width:"+image.getWidth());
//		image = ImageIO.read(new File("/Users/hongzhen/Downloads/1923327574.jpg"));
//		System.out.println("width:"+image.getWidth());
//		image = ImageIO.read(new File("/Users/hongzhen/Downloads/1923327575.jpg"));
//		System.out.println("width:"+image.getWidth());
//		File originFile = new File("/Users/hongzhen/Downloads/1923327571.jpg");
//
//		InputStream inputStream = new FileInputStream(originFile);
//
//		Integer angle = getShootAngle(inputStream);
//
//		if (angle!=0) {
//			byte[] bytes = rotate(inputStream, angle, "jpg");
//			inputStream = new ByteArrayInputStream(bytes);
//
//		}
//
//		File targetFile = new File("/Users/hongzhen/Downloads/ceshi.jpg");
//		FileUtils.copyInputStreamToFile(inputStream , targetFile);
//
//		BufferedImage image = ImageIO.read(targetFile);
//		System.out.println("width:"+image.getWidth());
	}
}

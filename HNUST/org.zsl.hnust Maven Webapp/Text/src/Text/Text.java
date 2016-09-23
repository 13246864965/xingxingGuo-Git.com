package Text;



public class Text {
	private static UploadThread uploadThread;
	private static String wardshipId = "68cecba9-cbeb-48f2-8418-b74a91385fb5";
	private static String Key = "HLJW2014";
	private static String ptime = "2016-08-01 10:44:11.000";
	
	public static void main(String[] args) {
		
		uploadThread = new UploadThread(wardshipId, Key, ptime,new HttpRedDataListener() {
			
			@Override
			public void HttpRedDataSuccess(String result) {
				System.out.println("结果:"+result);
				//结果需要base64解密下   Base64.decode(xxxxxxxx,Base64.DEFAULT);
			}
			
			@Override
			public void HttpRedDataFailure() {
				
			}
		});
		uploadThread.start();
	}
	
}

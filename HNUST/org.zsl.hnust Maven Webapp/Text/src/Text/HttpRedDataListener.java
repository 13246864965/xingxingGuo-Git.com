package Text;
/**
 * 请求心电数据  callback
 * @author lahm
 *
 */
public interface HttpRedDataListener {
	void HttpRedDataFailure();
	void HttpRedDataSuccess(String result);
}

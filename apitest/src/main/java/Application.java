import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/** 以下代码作用为启动一个Mock服务，并定义服务的Host是localhost，端口是9090.
    MOCK_DIR 的值设置为 Mock:
        作用是告知 Mock 服务接口的mapping文件和response文件放在项目目录的resources下面的Mockfolder内
 ***/

public class Application {

    /** 定义mock服务的端口 */
    private static final int PORT = 9090;

    /** 定义mock服务的地址 */
    private static final String LOCALHOST = "localhost";

    /** 定义mapping文件目录 */
    private static final String MOCK_DIR = "mock";

    /** main方法中的内容为启动mock服务的固定写法 */
    public static void main(String[] args) {

        final WireMockConfiguration config = wireMockConfig()
                                            .port(PORT)
                                            .usingFilesUnderClasspath(MOCK_DIR);

        final WireMockServer wireMockServer = new WireMockServer(config);
        wireMockServer.start();
        WireMock.configureFor(LOCALHOST,PORT);
    }
}

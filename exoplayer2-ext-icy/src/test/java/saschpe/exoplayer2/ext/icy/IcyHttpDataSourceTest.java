package saschpe.exoplayer2.ext.icy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import saschpe.exoplayer2.ext.icy.test.Constants;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public final class IcyHttpDataSourceTest {
    @Test
    public void createDataSourceFromBuilder() {
        // Arrange, act
        IcyHttpDataSource source = new IcyHttpDataSource.Builder(Constants.TEST_USER_AGENT)
                .setConnectTimeoutMillis(Constants.TEST_CONNECT_TIMEOUT_MS)
                .setReadTimeoutMillis(Constants.TEST_READ_TIMEOUT_MS)
                .setAllowCrossProtocolRedirects(Constants.TEST_ALLOW_CROSS_PROTOCOL_REDIRECTS)
                .build();

        // Assert
        assertNotNull(source);
    }
}

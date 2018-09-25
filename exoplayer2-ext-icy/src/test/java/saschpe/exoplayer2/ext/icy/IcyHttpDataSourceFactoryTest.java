package saschpe.exoplayer2.ext.icy;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import okhttp3.OkHttpClient;
import saschpe.exoplayer2.ext.icy.test.Constants;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public final class IcyHttpDataSourceFactoryTest {
    private final TransferListener<DataSource> TEST_TRANSFER_LISTENER = new TransferListener<DataSource>() {
        @Override
        public void onTransferStart(DataSource source, DataSpec dataSpec) {

        }

        @Override
        public void onBytesTransferred(DataSource source, int bytesTransferred) {

        }

        @Override
        public void onTransferEnd(DataSource source) {

        }
    };
    private final IcyHttpDataSource.IcyHeadersListener TEST_ICY_HEADERS_LISTENER = new IcyHttpDataSource.IcyHeadersListener() {
        @Override
        public void onIcyHeaders(IcyHttpDataSource.IcyHeaders icyHeaders) {

        }
    };
    private final IcyHttpDataSource.IcyMetadataListener TEST_ICY_METADATA_LISTENER = new IcyHttpDataSource.IcyMetadataListener() {
        @Override
        public void onIcyMetaData(IcyHttpDataSource.IcyMetadata icyMetadata) {

        }
    };

    @Test
    public void createDataSourceViaFactoryFromFactoryBuilder() {
        // Arrange
        OkHttpClient client = new OkHttpClient.Builder().build();
        IcyHttpDataSourceFactory factory = new IcyHttpDataSourceFactory.Builder(client)
                .setUserAgent(Constants.TEST_USER_AGENT)
                .setTransferListener(TEST_TRANSFER_LISTENER)
                .setIcyHeadersListener(TEST_ICY_HEADERS_LISTENER)
                .setIcyMetadataChangeListener(TEST_ICY_METADATA_LISTENER)
                .build();
        HttpDataSource.RequestProperties requestProperties = new HttpDataSource.RequestProperties();

        // Act
        IcyHttpDataSource source = factory.createDataSourceInternal(requestProperties);

        // Assert
        assertNotNull(source);
    }
}

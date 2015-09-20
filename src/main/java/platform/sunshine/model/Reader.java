package platform.sunshine.model;

import java.sql.Timestamp;

/**
 * Created by sunshine on 15/9/20.
 */
public class Reader {
    private String readerWechat;

    private Timestamp createAt;

    public String getReaderWechat() {
        return readerWechat;
    }

    public void setReaderWechat(String readerWechat) {
        this.readerWechat = readerWechat;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}

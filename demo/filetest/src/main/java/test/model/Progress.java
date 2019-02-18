package test.model;

import java.io.Serializable;

public class Progress implements Serializable {
    private Long now;
    private Long sum;
    private Integer file;

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }


    public Integer getFile() {
        return file;
    }

    public void setFile(Integer file) {
        this.file = file;
    }
}
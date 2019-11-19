package com.cn.ftp.ftplet;

import org.apache.ftpserver.ftplet.DefaultFtplet;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.FtpletResult;

import java.io.IOException;

public class FileUpdateEndFtplet extends DefaultFtplet {
    @Override
    public FtpletResult onConnect(FtpSession session) throws FtpException, IOException {
        return super.onConnect(session);
    }
}

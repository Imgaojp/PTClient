package cn.gabongao.utils.downloader;


import cn.gabongao.utils.entity.Page;
import cn.gabongao.utils.entity.Request;
import cn.gabongao.utils.entity.Task;

public interface Downloader {

    /**
     * Downloads web pages and store in Page object.
     *
     * @param request request
     * @param task    task
     * @return page
     */
    Page download(Request request, Task task);

    /**
     * Tell the downloader how many threads the spider used.
     *
     * @param threadNum number of threads
     */
    void setThread(int threadNum);
}

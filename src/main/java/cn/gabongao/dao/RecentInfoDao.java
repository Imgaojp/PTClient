package cn.gabongao.dao;

import cn.gabongao.mapper.RecentInfoMapper;
import cn.gabongao.model.Info;
import cn.gabongao.model.RecentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * Created by Imgaojp on 2018/9/6.
 */
@Component
public class RecentInfoDao {

    private RecentInfoMapper dao;

    @Autowired
    public RecentInfoDao(RecentInfoMapper dao) {
        this.dao = dao;
    }


    public int insert(RecentInfo recentInfo) {
        return dao.insert(recentInfo);
    }


    public List<RecentInfo> all() {
        return dao.all();
    }

    public void remove(Info info) {
        dao.remove(info.getSite());
    }

    public List<RecentInfo> getSiteRecentInfo(Info info) {
        return dao.getSiteRecentInfo(info.getSite());
    }

    public List<RecentInfo> get30RecentInfo(Info info) {
        return dao.get30RecentInfo(info.getSite());
    }

}

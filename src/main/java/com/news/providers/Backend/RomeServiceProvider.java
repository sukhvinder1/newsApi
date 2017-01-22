package com.news.providers.Backend;

import com.news.providers.Entity.RomeDO;

import java.util.List;

/**
 * Created by Sukh on 2017-01-21.
 */
public interface RomeServiceProvider {

    List<RomeDO> getRomeDO(String url);
}

package top.wycfight.thankspring.modules.test.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import top.wycfight.thankspring.modules.test.bean.Book;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2018-11-27 13:30
 * @modified By:
 **/
public interface BookRepository extends ElasticsearchCrudRepository<Book,Long> {

}

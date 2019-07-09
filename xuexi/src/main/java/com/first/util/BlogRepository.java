package com.first.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.first.bean.User;

public interface BlogRepository extends PagingAndSortingRepository<User, Integer> {
	/**
	 * Pageable 是Spring Data库中定义的一个接口，该接口是所有分页相关信息的一个抽象，
	 * 通过该接口，我们可以得到和分页相关所有信息（例如pageNumber、pageSize等），
	 * 这样，Jpa就能够通过pageable参数来得到一个带分页信息的Sql语句。
	 * 
	 * Page类也是Spring Data提供的一个接口，该接口表示一部分数据的集合以及
	 * 其相关的下一部分数据、数据总数等相关信息，通过该接口，我们可以得到数据的总体信息（数据总数、总页数...）
	 * 以及当前数据的信息（当前数据的集合、当前页数等）
	 * @param pageable
	 * @return
	 */
	Page<User> findByDeleteUserId(Pageable pageable);
	
	
}

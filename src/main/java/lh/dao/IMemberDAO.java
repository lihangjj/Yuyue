package lh.dao;

import lh.vo.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IMemberDAO extends IDAO<String,Member> {
    boolean doCreate(Member vo) throws Exception;
    List<Member> findAllSplit(Map<String, Object> map);
}

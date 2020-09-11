import com.wjj.community.louvain.graph.algo.CommunityInfo;
import com.wjj.community.louvain.graph.algo.LouvainCalculator;
import com.wjj.community.louvain.graph.entity.Graph;
import com.wjj.community.louvain.graph.entity.Link;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Aldebran
 * @since 11/09/2020
 */
public class MyTest {

    /**
     * 单层划分
     */
    @Test
    public void testSingle() {
        Graph g = new Graph();
        // 0->1->2->0
        g.addLinks(Arrays.asList(new Link(0, 1, 1.0)));
        g.addLinks(Arrays.asList(new Link(1, 2, 1.0)));
        g.addLinks(Arrays.asList(new Link(2, 0, 1.0)));
        // 3->4->5->3
        g.addLinks(Arrays.asList(new Link(3, 4, 1.0)));
        g.addLinks(Arrays.asList(new Link(4, 5, 1.0)));
        g.addLinks(Arrays.asList(new Link(5, 3, 1.0)));
        // 构造计算器
        LouvainCalculator louvainCalculator = new LouvainCalculator(g);
        // 执行划分
        CommunityInfo communityInfo = louvainCalculator.findCommunitiesSingleLevel();
        // 输出结果
        System.out.println(communityInfo);
    }

    /**
     * 多层划分
     */
    @Test
    public void testMultiple() {
        Graph g = new Graph();
        // 0->1->2->0
        g.addLinks(Arrays.asList(new Link(0, 1, 1.0)));
        g.addLinks(Arrays.asList(new Link(1, 2, 1.0)));
        g.addLinks(Arrays.asList(new Link(2, 0, 1.0)));
        // 3->4->5->3
        g.addLinks(Arrays.asList(new Link(3, 4, 1.0)));
        g.addLinks(Arrays.asList(new Link(4, 5, 1.0)));
        g.addLinks(Arrays.asList(new Link(5, 3, 1.0)));
        // 6->7->8->6->5
        g.addLinks(Arrays.asList(new Link(6, 7, 1.0)));
        g.addLinks(Arrays.asList(new Link(7, 8, 1.0)));
        g.addLinks(Arrays.asList(new Link(8, 9, 1.0)));
        g.addLinks(Arrays.asList(new Link(9, 6, 1.0)));
        g.addLinks(Arrays.asList(new Link(6, 8, 1.0)));
        g.addLinks(Arrays.asList(new Link(7, 9, 1.0)));
        g.addLinks(Arrays.asList(new Link(6, 5, 1.0)));
        // 构造计算器
        LouvainCalculator louvainCalculator = new LouvainCalculator(g);
        // 执行划分
        CommunityInfo communityInfo = louvainCalculator.findCommunitiesMultiLevel(2);
        // 输出结果
        System.out.println(communityInfo);
    }

}

package algCommon;

public class ����ģ�� {

}

// DFSģ��
/*
void dfs(...) 
{
    // �����ݹ������
    if (...) {
        ..... // �ѡ���ǰ����� ���� ������������� ��
        return;
    }

    // �����ݹ飬��������л��ݣ�Ҳ����û��
    if (...) {

        ... // �������б��浱ǰ����
        dfs() 
        ... // ��������ɾ�����汣������ݣ�ע����������¾ͳ�Ϊ���ݣ�����������dfs��һ�����裩
    }
}
*/


// BFSģ��
/*
void bfs(...)
{
    queue q;
    q.push(startRoot);
    while (!q.empty()) {
        // ���սڵ㴦��
        curNode = q.front();
        q.pop();

        if (...) {
            // ����curNode,����curNode������Nodes�������
        }
    }
}
*/

// BFSģ�壨��ΰ棩
/*
void bfs(...)
{
    queue q;
    q.push(startRoot);
    while (!q.empty()) {
        // ���ղ�δ���
        size = q.size();
        for (i = 0; i < size; i++) {
            curNode = q.front();
            q.pop();

            if (... ) {
                // ����curNode,����curNode������Nodes�������
            }
        }
    }

}
*/
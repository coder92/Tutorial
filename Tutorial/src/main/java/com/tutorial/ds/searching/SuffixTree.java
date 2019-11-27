/*
package com.tutorial.ds.searching;

import com.tutorial.ds.linkedlist.Node;

public class SuffixTreeImpl2{
    static int MAX_ChAR = 26;
    char[] text = new char[100];
    SuffixTreeNode root = null;

    SuffixTreeNode lastNewNode =  null;
    SuffixTreeNode activeNode =  null;

    //input string character index
    int activeEdge =-1;
    int activeLength = 0;

    int remainingSuffixCount=0;
    int leafEnd =-1;
    Integer rootEnd =  null;
    Integer splitEnd = null;

    int size =-1;

    public void buildSuffixTree(){
        size = text.length;
        int i;
        rootEnd =  - 1;

    */
/*Root is a special node with start and end indices as -1,
    as it has no parent from where an edge comes to root*//*

        root = newNode(-1, rootEnd);

        activeNode = root; //First activeNode will be root
        for (i=0; i<size; i++)
            extendSuffixTree(i);
        int labelHeight = 0;
        setSuffixIndexByDFS(root, labelHeight);
    }

    public SuffixTreeNode newNode(Integer start, Integer end){
        SuffixTreeNode node = new SuffixTreeNode();
        for(int i=0;i<MAX_ChAR;i++){
            node.children[i] = null;
        }
        */
/*For root node, suffixLink will be set to NULL
        For internal nodes, suffixLink will be set to root
        by default in  current extension and may change in
        next extension*//*

        node.suffixLink=root;
        node.start = start;
        node.end=end;

        */
/*suffixIndex will be set to -1 by default and
          actual suffix index will be set later for leaves
          at the end of all phases*//*

        node.suffixIndex=-1;
        return node;
    }

    public void extendSuffixTree(int pos){
        */
/*Extension Rule 1, this takes care of extending all
         leaves created so far in tree*//*

        leafEnd = pos;

    */
/*Increment remainingSuffixCount indicating that a
    new suffix added to the list of suffixes yet to be
    added in tree*//*

        remainingSuffixCount++;

    */
/*set lastNewNode to NULL while starting a new phase,
     indicating there is no internal node waiting for
     it's suffix link reset in current phase*//*

        lastNewNode = null;

        //Add all suffixes (yet to be added) one by one in tree
        while(remainingSuffixCount > 0) {

            if (activeLength == 0)
                activeEdge = pos; //APCFALZ

            // There is no outgoing edge starting with
            // activeEdge from activeNode
            if (activeNode.children == null)
            {
                //Extension Rule 2 (A new leaf edge gets created)
                activeNode.children = newNode(pos,leafEnd);

            */
/*A new leaf edge is created in above line starting
             from  an existng node (the current activeNode), and
             if there is any internal node waiting for it's suffix
             link get reset, point the suffix link from that last
             internal node to current activeNode. Then set lastNewNode
             to NULL indicating no more node waiting for suffix link
             reset.*//*

                if (lastNewNode != NULL)
                {
                    lastNewNode->suffixLink = activeNode;
                    lastNewNode = NULL;
                }
            }
            // There is an outgoing edge starting with activeEdge
            // from activeNode
        else
            {
                // Get the next node at the end of edge starting
                // with activeEdge
                Node *next = activeNode->children];
                if (walkDown(next))//Do walkdown
                {
                    //Start from next node (the new activeNode)
                    continue;
                }
            */
/*Extension Rule 3 (current character being processed
              is already on the edge)*//*

                if (text[next->start + activeLength] == text[pos])
                {
                    //If a newly created node waiting for it's
                    //suffix link to be set, then set suffix link
                    //of that waiting node to curent active node
                    if(lastNewNode != NULL && activeNode != root)
                    {
                        lastNewNode->suffixLink = activeNode;
                        lastNewNode = NULL;
                    }

                    //APCFER3
                    activeLength++;
                */
/*STOP all further processing in this phase
                and move on to next phase*//*

                    break;
                }

            */
/*We will be here when activePoint is in middle of
              the edge being traversed and current character
              being processed is not  on the edge (we fall off
              the tree). In this case, we add a new internal node
              and a new leaf edge going out of that new node. This
              is Extension Rule 2, where a new leaf edge and a new
            internal node get created*//*

                splitEnd = (int*) malloc(sizeof(int));
            *splitEnd = next->start + activeLength - 1;

                //New internal node
                Node *split = newNode(next->start, splitEnd);
                activeNode->children] = split;

                //New leaf coming out of new internal node
                split->children] = newNode(pos, &leafEnd);
                next->start += activeLength;
                split->children] = next;

            */
/*We got a new internal node here. If there is any
              internal node created in last extensions of same
              phase which is still waiting for it's suffix link
              reset, do it now.*//*

                if (lastNewNode != NULL)
                {
            */
/*suffixLink of lastNewNode points to current newly
              created internal node*//*

                    lastNewNode->suffixLink = split;
                }

            */
/*Make the current newly created internal node waiting
              for it's suffix link reset (which is pointing to root
              at present). If we come across any other internal node
              (existing or newly created) in next extension of same
              phase, when a new leaf edge gets added (i.e. when
              Extension Rule 2 applies is any of the next extension
              of same phase) at that point, suffixLink of this node
              will point to that internal node.*//*

                lastNewNode = split;
            }

        */
/* One suffix got added in tree, decrement the count of
          suffixes yet to be added.*//*

            remainingSuffixCount--;
            if (activeNode == root && activeLength > 0) //APCFER2C1
            {
                activeLength--;
                activeEdge = pos - remainingSuffixCount + 1;
            }
            else if (activeNode != root) //APCFER2C2
            {
                activeNode = activeNode->suffixLink;
            }
        }
    }
    public static void main(String[] args) {

    }
}

class SuffixTreeNode{
    SuffixTreeNode children[] = new SuffixTreeNode[SuffixTree.MAX_CHAR];
    //pointer to other node via suffixLink
    SuffixTreeNode suffixLink;

    //start , end of an edge
    int start, end;

    int suffixIndex;
}
*/

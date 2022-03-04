/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancomp;

/**
 *
 * @author Robenus
 */
class Node implements Comparable<Node>{
        public final char character;
        public final  int frequency;
        public final Node leftChild;
        public final Node RightChild;
        int fq;

        Node(final char character, 
                     final int frequency, 
                     final Node leftChild, final Node RightChild){
            this.character = character;
            this.frequency=frequency;
            this.leftChild = leftChild;
            this.RightChild = RightChild;
        }
        boolean isLeaf(){
            return this.leftChild==null && this.RightChild == null;
        }

    @Override
    
        public int compareTo(Node that) {
            // TODO Auto-generated method stub
            final int frequencyComparison = Integer.compare(this.frequency, that.frequency);
            if(frequencyComparison!=0){
                return frequencyComparison;
            }
            return Integer.compare(this.character, that.character);
        }
    }
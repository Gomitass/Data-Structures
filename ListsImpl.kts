interface List{
    fun pushFront(key:String)
    fun topFront():String?
    fun popFront():String?
    fun append(key:String)
    fun topBack():String?
    fun popBack():String?
    fun find(key:String)
}

class Node(val key : String,var next:Node? = null){}


class linkedList(var head:Node? = null,var tail:Node? = null):List{

    override fun pushFront(key:String){
        val node:Node = Node(key)
        node.next = head
        head = node
        if (tail == null){
            tail = head
        }
    }
    override fun topFront():String?{
        return head?.key
    }
    override fun popFront():String?{
        if (head == null){
            throw Exception("ERROR:The list is empty")
        }
        else{
            val a = head?.key
            head = head?.next
            if(head == null){
            tail = null
            }
            return a
        }
    }
    override fun append(key:String){
        val node:Node = Node(key)
        node.next = null
        if (tail == null){
            tail = node
            head = tail
        }
        else{
            tail?.next = node
            tail = node
        }
    }
    override fun topBack():String?{
        return tail?.key
    }
    override fun popBack():String?{
        if (head == null){
            throw Exception("ERROR:The list is empty")
        }
        if (head == tail){
            val a = tail?.key
            tail = null
            head = tail
            return a
        }
        else{
            var p = head
            while (p?.next?.next != null){
                p = p.next
            }
            val a = p?.next
            p?.next = null
            tail = p
            return a?.key
        }
    }
    override fun find(key:String){

    }

    override fun toString(): String {
        var b = "null"
        if (head != null){
            b = "[" + head?.key
            var a = head
            while (a?.next != null){
                a = a.next
                b += "," + a?.key
            }
            b += "]"
        }
        return b
    }
}
//TESTS
var list = linkedList()
list.pushFront("A")
println(list)
println(list.tail)
list.append("B")
println(list)
println(list.popBack())
println(list)
println(list.popBack())
println(list)
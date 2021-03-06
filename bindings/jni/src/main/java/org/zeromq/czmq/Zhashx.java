/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Please refer to the README for information about making permanent changes.  #
################################################################################
*/
package org.zeromq.czmq;

public class Zhashx implements AutoCloseable{
    static {
        try {
            System.loadLibrary ("czmqjni");
        }
        catch (Exception e) {
            System.exit (-1);
        }
    }
    long self;
    /*
    Create a new, empty hash container
    */
    native static long __init ();
    public Zhashx () {
        /*  TODO: if __init fails, self is null...  */
        self = __init ();
    }
    /*
    Destroy a hash container and all items in it
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Insert item into hash table with specified key and item.               
    If key is already present returns -1 and leaves existing item unchanged
    Returns 0 on success.                                                  
    */
    native static int __insert (long self, long key, long item);
    public int insert (long self, long key, long item) {
        return __insert (self, key, item);
    }
    /*
    Update or insert item into hash table with specified key and item. If the
    key is already present, destroys old item and inserts new one. If you set
    a container item destructor, this is called on the old value. If the key 
    was not already present, inserts a new item. Sets the hash cursor to the 
    new item.                                                                
    */
    native static void __update (long self, long key, long item);
    public void update (long self, long key, long item) {
        __update (self, key, item);
    }
    /*
    Remove an item specified by key from the hash table. If there was no such
    item, this function does nothing.                                        
    */
    native static void __delete (long self, long key);
    public void delete (long self, long key) {
        __delete (self, key);
    }
    /*
    Delete all items from the hash table. If the key destructor is  
    set, calls it on every key. If the item destructor is set, calls
    it on every item.                                               
    */
    native static void __purge (long self);
    public void purge (long self) {
        __purge (self);
    }
    /*
    Return the item at the specified key, or null
    */
    native static long __lookup (long self, long key);
    public long lookup (long self, long key) {
        return __lookup (self, key);
    }
    /*
    Reindexes an item from an old key to a new key. If there was no such
    item, does nothing. Returns 0 if successful, else -1.               
    */
    native static int __rename (long self, long oldKey, long newKey);
    public int rename (long self, long oldKey, long newKey) {
        return __rename (self, oldKey, newKey);
    }
    /*
    Set a free function for the specified hash table item. When the item is
    destroyed, the free function, if any, is called on that item.          
    Use this when hash items are dynamically allocated, to ensure that     
    you don't have memory leaks. You can pass 'free' or NULL as a free_fn. 
    Returns the item, or NULL if there is no such item.                    
    */
    native static long __freefn (long self, long key, long freeFn);
    public long freefn (long self, long key, long freeFn) {
        return __freefn (self, key, freeFn);
    }
    /*
    Return the number of keys/items in the hash table
    */
    native static long __size (long self);
    public long size (long self) {
        return __size (self);
    }
    /*
    Return a zlistx_t containing the keys for the items in the       
    table. Uses the key_duplicator to duplicate all keys and sets the
    key_destructor as destructor for the list.                       
    */
    native static long __keys (long self);
    public long keys (long self) {
        return __keys (self);
    }
    /*
    Return a zlistx_t containing the values for the items in the  
    table. Uses the duplicator to duplicate all items and sets the
    destructor as destructor for the list.                        
    */
    native static long __values (long self);
    public long values (long self) {
        return __values (self);
    }
    /*
    Simple iterator; returns first item in hash table, in no given order, 
    or NULL if the table is empty. This method is simpler to use than the 
    foreach() method, which is deprecated. To access the key for this item
    use zhashx_cursor(). NOTE: do NOT modify the table while iterating.   
    */
    native static long __first (long self);
    public long first (long self) {
        return __first (self);
    }
    /*
    Simple iterator; returns next item in hash table, in no given order, 
    or NULL if the last item was already returned. Use this together with
    zhashx_first() to process all items in a hash table. If you need the 
    items in sorted order, use zhashx_keys() and then zlistx_sort(). To  
    access the key for this item use zhashx_cursor(). NOTE: do NOT modify
    the table while iterating.                                           
    */
    native static long __next (long self);
    public long next (long self) {
        return __next (self);
    }
    /*
    After a successful first/next method, returns the key for the item that
    was returned. This is a constant string that you may not modify or     
    deallocate, and which lasts as long as the item in the hash. After an  
    unsuccessful first/next, returns NULL.                                 
    */
    native static long __cursor (long self);
    public long cursor (long self) {
        return __cursor (self);
    }
    /*
    Add a comment to hash table before saving to disk. You can add as many   
    comment lines as you like. These comment lines are discarded when loading
    the file. If you use a null format, all comments are deleted.            
    */
    native static void __comment (long self, String format);
    public void comment (long self, String format) {
        __comment (self, format);
    }
    /*
    Save hash table to a text file in name=value format. Hash values must be
    printable strings; keys may not contain '=' character. Returns 0 if OK, 
    else -1 if a file error occurred.                                       
    */
    native static int __save (long self, String filename);
    public int save (long self, String filename) {
        return __save (self, filename);
    }
    /*
    Load hash table from a text file in name=value format; hash table must 
    already exist. Hash values must printable strings; keys may not contain
    '=' character. Returns 0 if OK, else -1 if a file was not readable.    
    */
    native static int __load (long self, String filename);
    public int load (long self, String filename) {
        return __load (self, filename);
    }
    /*
    When a hash table was loaded from a file by zhashx_load, this method will
    reload the file if it has been modified since, and is "stable", i.e. not 
    still changing. Returns 0 if OK, -1 if there was an error reloading the  
    file.                                                                    
    */
    native static int __refresh (long self);
    public int refresh (long self) {
        return __refresh (self);
    }
    /*
    Serialize hash table to a binary frame that can be sent in a message.
    The packed format is compatible with the 'dictionary' type defined in
    http://rfc.zeromq.org/spec:35/FILEMQ, and implemented by zproto:     
                                                                         
       ; A list of name/value pairs                                      
       dictionary      = dict-count *( dict-name dict-value )            
       dict-count      = number-4                                        
       dict-value      = longstr                                         
       dict-name       = string                                          
                                                                         
       ; Strings are always length + text contents                       
       longstr         = number-4 *VCHAR                                 
       string          = number-1 *VCHAR                                 
                                                                         
       ; Numbers are unsigned integers in network byte order             
       number-1        = 1OCTET                                          
       number-4        = 4OCTET                                          
                                                                         
    Comments are not included in the packed data. Item values MUST be    
    strings.                                                             
    */
    native static long __pack (long self);
    public long pack (long self) {
        return __pack (self);
    }
    /*
    Unpack binary frame into a new hash table. Packed data must follow format
    defined by zhashx_pack. Hash table is set to autofree. An empty frame    
    unpacks to an empty hash table.                                          
    */
    native static long __unpack (long frame);
    public long unpack (long frame) {
        return __unpack (frame);
    }
    /*
    Make a copy of the list; items are duplicated if you set a duplicator 
    for the list, otherwise not. Copying a null reference returns a null  
    reference. Note that this method's behavior changed slightly for CZMQ 
    v3.x, as it does not set nor respect autofree. It does however let you
    duplicate any hash table safely. The old behavior is in zhashx_dup_v2.
    */
    native static long __dup (long self);
    public long dup (long self) {
        return __dup (self);
    }
    /*
    Set a user-defined deallocator for hash items; by default items are not
    freed when the hash is destroyed.                                      
    */
    native static void __set_destructor (long self, long destructor);
    public void setDestructor (long self, long destructor) {
        __set_destructor (self, destructor);
    }
    /*
    Set a user-defined duplicator for hash items; by default items are not
    copied when the hash is duplicated.                                   
    */
    native static void __set_duplicator (long self, long duplicator);
    public void setDuplicator (long self, long duplicator) {
        __set_duplicator (self, duplicator);
    }
    /*
    Set a user-defined deallocator for keys; by default keys are freed
    when the hash is destroyed using free().                          
    */
    native static void __set_key_destructor (long self, long destructor);
    public void setKeyDestructor (long self, long destructor) {
        __set_key_destructor (self, destructor);
    }
    /*
    Set a user-defined duplicator for keys; by default keys are duplicated
    using strdup.                                                         
    */
    native static void __set_key_duplicator (long self, long duplicator);
    public void setKeyDuplicator (long self, long duplicator) {
        __set_key_duplicator (self, duplicator);
    }
    /*
    Set a user-defined comparator for keys; by default keys are
    compared using strcmp.                                     
    */
    native static void __set_key_comparator (long self, long comparator);
    public void setKeyComparator (long self, long comparator) {
        __set_key_comparator (self, comparator);
    }
    /*
    Set a user-defined comparator for keys; by default keys are
    compared using strcmp.                                     
    */
    native static void __set_key_hasher (long self, long hasher);
    public void setKeyHasher (long self, long hasher) {
        __set_key_hasher (self, hasher);
    }
    /*
    Make copy of hash table; if supplied table is null, returns null.    
    Does not copy items themselves. Rebuilds new table so may be slow on 
    very large tables. NOTE: only works with item values that are strings
    since there's no other way to know how to duplicate the item value.  
    */
    native static long __dup_v2 (long self);
    public long dupV2 (long self) {
        return __dup_v2 (self);
    }
    /*
    DEPRECATED as clumsy -- use set_destructor instead
    Set hash for automatic value destruction          
    */
    native static void __autofree (long self);
    public void autofree (long self) {
        __autofree (self);
    }
    /*
    DEPRECATED as clumsy -- use zhashx_first/_next instead                 
    Apply function to each item in the hash table. Items are iterated in no
    defined order. Stops if callback function returns non-zero and returns 
    final return code from callback function (zero = success).             
    Callback function for zhashx_foreach method                            
    */
    native static int __foreach (long self, long callback, long argument);
    public int foreach (long self, long callback, long argument) {
        return __foreach (self, callback, argument);
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public void test (boolean verbose) {
        __test (verbose);
    }
}

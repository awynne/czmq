################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Please refer to the README for information about making permanent changes.  #
################################################################################

module CZMQ
  module FFI

    # event-driven reactor
    class Zpoller
      class DestroyedError < RuntimeError; end

      # Boilerplate for self pointer, initializer, and finalizer
      class << self
        alias :__new :new
      end
      def initialize ptr, finalize=true
        @ptr = ptr
        if @ptr.null?
          @ptr = nil # Remove null pointers so we don't have to test for them.
        elsif finalize
          @finalizer = self.class.create_finalizer_for @ptr
          ObjectSpace.define_finalizer self, @finalizer
        end
      end
      def self.create_finalizer_for ptr
        Proc.new do
          ptr_ptr = ::FFI::MemoryPointer.new :pointer
          ptr_ptr.write_pointer ptr
          ::CZMQ::FFI.zpoller_destroy ptr_ptr
        end
      end
      def null?
        !@ptr or @ptr.null?
      end
      # Return internal pointer
      def __ptr
        raise DestroyedError unless @ptr
        @ptr
      end
      # So external Libraries can just pass the Object to a FFI function which expects a :pointer
      alias_method :to_ptr, :__ptr
      # Nullify internal pointer and return pointer pointer
      def __ptr_give_ref
        raise DestroyedError unless @ptr
        ptr_ptr = ::FFI::MemoryPointer.new :pointer
        ptr_ptr.write_pointer @ptr
        ObjectSpace.undefine_finalizer self if @finalizer
        @finalizer = nil
        @ptr = nil
        ptr_ptr
      end

      # Create new poller; the reader can be a libzmq socket (void *), a zsock_t
      # instance, or a zactor_t instance.                                       
      def self.new(reader, *args)
        ptr = ::CZMQ::FFI.zpoller_new(reader, *args)
        __new ptr
      end

      # Destroy a poller
      def destroy()
        return unless @ptr
        self_p = __ptr_give_ref
        result = ::CZMQ::FFI.zpoller_destroy(self_p)
        result
      end

      # Add a reader to be polled. Returns 0 if OK, -1 on failure. The reader may
      # be a libzmq void * socket, a zsock_t instance, or a zactor_t instance.   
      def add(reader)
        raise DestroyedError unless @ptr
        self_p = @ptr
        result = ::CZMQ::FFI.zpoller_add(self_p, reader)
        result
      end

      # Remove a reader from the poller; returns 0 if OK, -1 on failure. The   
      # reader may be a libzmq void * socket, a zsock_t instance, or a zactor_t
      # instance.                                                              
      def remove(reader)
        raise DestroyedError unless @ptr
        self_p = @ptr
        result = ::CZMQ::FFI.zpoller_remove(self_p, reader)
        result
      end

      # Poll the registered readers for I/O, return first reader that has input.  
      # The reader will be a libzmq void * socket, or a zsock_t or zactor_t       
      # instance as specified in zpoller_new/zpoller_add. The timeout should be   
      # zero or greater, or -1 to wait indefinitely. Socket priority is defined   
      # by their order in the poll list. If you need a balanced poll, use the low 
      # level zmq_poll method directly. If the poll call was interrupted (SIGINT),
      # or the ZMQ context was destroyed, or the timeout expired, returns NULL.   
      # You can test the actual exit condition by calling zpoller_expired () and  
      # zpoller_terminated (). The timeout is in msec.                            
      def wait(timeout)
        raise DestroyedError unless @ptr
        self_p = @ptr
        timeout = Integer(timeout)
        result = ::CZMQ::FFI.zpoller_wait(self_p, timeout)
        result
      end

      # Return true if the last zpoller_wait () call ended because the timeout
      # expired, without any error.                                           
      def expired()
        raise DestroyedError unless @ptr
        self_p = @ptr
        result = ::CZMQ::FFI.zpoller_expired(self_p)
        result
      end

      # Return true if the last zpoller_wait () call ended because the process
      # was interrupted, or the parent context was destroyed.                 
      def terminated()
        raise DestroyedError unless @ptr
        self_p = @ptr
        result = ::CZMQ::FFI.zpoller_terminated(self_p)
        result
      end

      # Ignore zsys_interrupted flag in this poller. By default, a zpoller_wait will 
      # return immediately if detects zsys_interrupted is set to something other than
      # zero. Calling zpoller_ignore_interrupts will supress this behavior.          
      def ignore_interrupts()
        raise DestroyedError unless @ptr
        self_p = @ptr
        result = ::CZMQ::FFI.zpoller_ignore_interrupts(self_p)
        result
      end

      # Self test of this class.
      def self.test(verbose)
        verbose = !(0==verbose||!verbose) # boolean
        result = ::CZMQ::FFI.zpoller_test(verbose)
        result
      end
    end
  end
end

################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Please refer to the README for information about making permanent changes.  #
################################################################################

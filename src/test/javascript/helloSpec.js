var hello = require('../../main/javascript/hello');

describe('saying hello to the world', function() {

  it('should not be shy', function() {
    expect(hello.world()).toEqual('Hello, World!');
  });
});

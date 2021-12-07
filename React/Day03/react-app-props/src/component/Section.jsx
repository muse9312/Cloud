import React, { Component } from 'react';

class Section extends Component {
    render() {
        return (
            <section>
                <h4>사용되는 숫자는 0에서 9까지 서로 다른 숫자이다.</h4>
                <h4>숫자는 맞지만 위치가 틀렸을 때는 볼.</h4>
                <h4>숫자와 위치가 전부 맞으면 스트라이크.</h4>
                <h4>숫자와 위치가 전부 틀리면 아웃. "틀렸다"는 게 중요하다.</h4>
                <h4>물론 무엇이 볼이고 스트라이크인지는 알려주지 않는다.</h4>
            </section>
        );
    }
}

export default Section;
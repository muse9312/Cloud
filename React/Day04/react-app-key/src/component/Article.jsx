import React, { Component } from 'react';

class Article extends Component {
    render() {
        return (
            <article>
                <table border="1">
                    <tbody>
                        <tr>
                            <td>
                                <div><strong>횟수</strong></div>
                            </td>
                            <td colspan="3">
                                <div><strong>숫자</strong></div>
                            </td>
                            <td>
                                <div><strong>판정</strong></div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>1</strong></div>
                            </td>
                            <td>
                                <div>8</div>
                            </td>
                            <td>
                                <div>3</div>
                            </td>
                            <td>
                                <div>0</div>
                            </td>
                            <td>
                                <div>아웃</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>2</strong></div>
                            </td>
                            <td>
                                <div>6</div>
                            </td>
                            <td>
                                <div>5</div>
                            </td>
                            <td>
                                <div>9</div>
                            </td>
                            <td>
                                <div>0S 1B</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>3</strong></div>
                            </td>
                            <td>
                                <div>2</div>
                            </td>
                            <td>
                                <div>6</div>
                            </td>
                            <td>
                                <div>4</div>
                            </td>
                            <td>
                                <div>1S 1B</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>4</strong></div>
                            </td>
                            <td>
                                <div>1</div>
                            </td>
                            <td>
                                <div>2</div>
                            </td>
                            <td>
                                <div>6</div>
                            </td>
                            <td>
                                <div>1S 2B</div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div><strong>5</strong></div>
                            </td>
                            <td>
                                <div>2</div>
                            </td>
                            <td>
                                <div>1</div>
                            </td>
                            <td>
                                <div>6</div>
                            </td>
                            <td>
                                <div>3S 0B</div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </article>
        );
    }
}

export default Article;
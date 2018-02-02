import React, { Component } from 'react';

const arr = [1, 2];

class Site extends Component {
    render() {
        return (
            <h3>{this.props.name}</h3>
        );
    }
}

class HelloMessage extends Component {
    
    // getInitialState() {
    //     return {
    //         name:'liuedou',
    //         site:'www.sanguo.com'
    //     };
    // }

    state = {
        name : 'liuhejie'
    };
    
    render() {
        return (
            <div>
                <h1>{arr}</h1>
                <Site name={this.state.name} />
            </div>
        );
    }
}


export default HelloMessage;
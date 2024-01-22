import React, { Component } from 'react'
import UnderexcLimIEEE1Service from '../services/UnderexcLimIEEE1Service';

class UpdateUnderexcLimIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateUnderexcLimIEEE1 = this.updateUnderexcLimIEEE1.bind(this);

    }

    componentDidMount(){
        UnderexcLimIEEE1Service.getUnderexcLimIEEE1ById(this.state.id).then( (res) =>{
            let underexcLimIEEE1 = res.data;
            this.setState({
            });
        });
    }

    updateUnderexcLimIEEE1 = (e) => {
        e.preventDefault();
        let underexcLimIEEE1 = {
            underexcLimIEEE1Id: this.state.id,
        };
        console.log('underexcLimIEEE1 => ' + JSON.stringify(underexcLimIEEE1));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcLimIEEE1Service.updateUnderexcLimIEEE1(underexcLimIEEE1).then( res => {
            this.props.history.push('/underexcLimIEEE1s');
        });
    }


    cancel(){
        this.props.history.push('/underexcLimIEEE1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcLimIEEE1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcLimIEEE1}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateUnderexcLimIEEE1Component

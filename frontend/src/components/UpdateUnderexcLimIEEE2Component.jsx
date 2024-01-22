import React, { Component } from 'react'
import UnderexcLimIEEE2Service from '../services/UnderexcLimIEEE2Service';

class UpdateUnderexcLimIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateUnderexcLimIEEE2 = this.updateUnderexcLimIEEE2.bind(this);

    }

    componentDidMount(){
        UnderexcLimIEEE2Service.getUnderexcLimIEEE2ById(this.state.id).then( (res) =>{
            let underexcLimIEEE2 = res.data;
            this.setState({
            });
        });
    }

    updateUnderexcLimIEEE2 = (e) => {
        e.preventDefault();
        let underexcLimIEEE2 = {
            underexcLimIEEE2Id: this.state.id,
        };
        console.log('underexcLimIEEE2 => ' + JSON.stringify(underexcLimIEEE2));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcLimIEEE2Service.updateUnderexcLimIEEE2(underexcLimIEEE2).then( res => {
            this.props.history.push('/underexcLimIEEE2s');
        });
    }


    cancel(){
        this.props.history.push('/underexcLimIEEE2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcLimIEEE2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcLimIEEE2}>Save</button>
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

export default UpdateUnderexcLimIEEE2Component

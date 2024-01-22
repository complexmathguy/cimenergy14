import React, { Component } from 'react'
import UnderexcLimX1Service from '../services/UnderexcLimX1Service';

class UpdateUnderexcLimX1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateUnderexcLimX1 = this.updateUnderexcLimX1.bind(this);

    }

    componentDidMount(){
        UnderexcLimX1Service.getUnderexcLimX1ById(this.state.id).then( (res) =>{
            let underexcLimX1 = res.data;
            this.setState({
            });
        });
    }

    updateUnderexcLimX1 = (e) => {
        e.preventDefault();
        let underexcLimX1 = {
            underexcLimX1Id: this.state.id,
        };
        console.log('underexcLimX1 => ' + JSON.stringify(underexcLimX1));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcLimX1Service.updateUnderexcLimX1(underexcLimX1).then( res => {
            this.props.history.push('/underexcLimX1s');
        });
    }


    cancel(){
        this.props.history.push('/underexcLimX1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcLimX1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcLimX1}>Save</button>
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

export default UpdateUnderexcLimX1Component

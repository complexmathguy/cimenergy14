import React, { Component } from 'react'
import UnderexcLimX2Service from '../services/UnderexcLimX2Service';

class UpdateUnderexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateUnderexcLimX2 = this.updateUnderexcLimX2.bind(this);

    }

    componentDidMount(){
        UnderexcLimX2Service.getUnderexcLimX2ById(this.state.id).then( (res) =>{
            let underexcLimX2 = res.data;
            this.setState({
            });
        });
    }

    updateUnderexcLimX2 = (e) => {
        e.preventDefault();
        let underexcLimX2 = {
            underexcLimX2Id: this.state.id,
        };
        console.log('underexcLimX2 => ' + JSON.stringify(underexcLimX2));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcLimX2Service.updateUnderexcLimX2(underexcLimX2).then( res => {
            this.props.history.push('/underexcLimX2s');
        });
    }


    cancel(){
        this.props.history.push('/underexcLimX2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcLimX2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcLimX2}>Save</button>
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

export default UpdateUnderexcLimX2Component

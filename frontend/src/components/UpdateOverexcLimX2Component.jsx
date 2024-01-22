import React, { Component } from 'react'
import OverexcLimX2Service from '../services/OverexcLimX2Service';

class UpdateOverexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateOverexcLimX2 = this.updateOverexcLimX2.bind(this);

    }

    componentDidMount(){
        OverexcLimX2Service.getOverexcLimX2ById(this.state.id).then( (res) =>{
            let overexcLimX2 = res.data;
            this.setState({
            });
        });
    }

    updateOverexcLimX2 = (e) => {
        e.preventDefault();
        let overexcLimX2 = {
            overexcLimX2Id: this.state.id,
        };
        console.log('overexcLimX2 => ' + JSON.stringify(overexcLimX2));
        console.log('id => ' + JSON.stringify(this.state.id));
        OverexcLimX2Service.updateOverexcLimX2(overexcLimX2).then( res => {
            this.props.history.push('/overexcLimX2s');
        });
    }


    cancel(){
        this.props.history.push('/overexcLimX2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OverexcLimX2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOverexcLimX2}>Save</button>
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

export default UpdateOverexcLimX2Component

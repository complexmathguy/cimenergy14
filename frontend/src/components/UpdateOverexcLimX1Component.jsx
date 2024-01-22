import React, { Component } from 'react'
import OverexcLimX1Service from '../services/OverexcLimX1Service';

class UpdateOverexcLimX1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateOverexcLimX1 = this.updateOverexcLimX1.bind(this);

    }

    componentDidMount(){
        OverexcLimX1Service.getOverexcLimX1ById(this.state.id).then( (res) =>{
            let overexcLimX1 = res.data;
            this.setState({
            });
        });
    }

    updateOverexcLimX1 = (e) => {
        e.preventDefault();
        let overexcLimX1 = {
            overexcLimX1Id: this.state.id,
        };
        console.log('overexcLimX1 => ' + JSON.stringify(overexcLimX1));
        console.log('id => ' + JSON.stringify(this.state.id));
        OverexcLimX1Service.updateOverexcLimX1(overexcLimX1).then( res => {
            this.props.history.push('/overexcLimX1s');
        });
    }


    cancel(){
        this.props.history.push('/overexcLimX1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OverexcLimX1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOverexcLimX1}>Save</button>
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

export default UpdateOverexcLimX1Component

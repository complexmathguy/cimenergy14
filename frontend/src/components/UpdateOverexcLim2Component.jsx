import React, { Component } from 'react'
import OverexcLim2Service from '../services/OverexcLim2Service';

class UpdateOverexcLim2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateOverexcLim2 = this.updateOverexcLim2.bind(this);

    }

    componentDidMount(){
        OverexcLim2Service.getOverexcLim2ById(this.state.id).then( (res) =>{
            let overexcLim2 = res.data;
            this.setState({
            });
        });
    }

    updateOverexcLim2 = (e) => {
        e.preventDefault();
        let overexcLim2 = {
            overexcLim2Id: this.state.id,
        };
        console.log('overexcLim2 => ' + JSON.stringify(overexcLim2));
        console.log('id => ' + JSON.stringify(this.state.id));
        OverexcLim2Service.updateOverexcLim2(overexcLim2).then( res => {
            this.props.history.push('/overexcLim2s');
        });
    }


    cancel(){
        this.props.history.push('/overexcLim2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OverexcLim2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOverexcLim2}>Save</button>
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

export default UpdateOverexcLim2Component

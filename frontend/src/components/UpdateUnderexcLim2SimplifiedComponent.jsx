import React, { Component } from 'react'
import UnderexcLim2SimplifiedService from '../services/UnderexcLim2SimplifiedService';

class UpdateUnderexcLim2SimplifiedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateUnderexcLim2Simplified = this.updateUnderexcLim2Simplified.bind(this);

    }

    componentDidMount(){
        UnderexcLim2SimplifiedService.getUnderexcLim2SimplifiedById(this.state.id).then( (res) =>{
            let underexcLim2Simplified = res.data;
            this.setState({
            });
        });
    }

    updateUnderexcLim2Simplified = (e) => {
        e.preventDefault();
        let underexcLim2Simplified = {
            underexcLim2SimplifiedId: this.state.id,
        };
        console.log('underexcLim2Simplified => ' + JSON.stringify(underexcLim2Simplified));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcLim2SimplifiedService.updateUnderexcLim2Simplified(underexcLim2Simplified).then( res => {
            this.props.history.push('/underexcLim2Simplifieds');
        });
    }


    cancel(){
        this.props.history.push('/underexcLim2Simplifieds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcLim2Simplified</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcLim2Simplified}>Save</button>
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

export default UpdateUnderexcLim2SimplifiedComponent

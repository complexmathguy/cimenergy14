import React, { Component } from 'react'
import LimitSetService from '../services/LimitSetService';

class UpdateLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLimitSet = this.updateLimitSet.bind(this);

    }

    componentDidMount(){
        LimitSetService.getLimitSetById(this.state.id).then( (res) =>{
            let limitSet = res.data;
            this.setState({
            });
        });
    }

    updateLimitSet = (e) => {
        e.preventDefault();
        let limitSet = {
            limitSetId: this.state.id,
        };
        console.log('limitSet => ' + JSON.stringify(limitSet));
        console.log('id => ' + JSON.stringify(this.state.id));
        LimitSetService.updateLimitSet(limitSet).then( res => {
            this.props.history.push('/limitSets');
        });
    }


    cancel(){
        this.props.history.push('/limitSets');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LimitSet</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLimitSet}>Save</button>
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

export default UpdateLimitSetComponent

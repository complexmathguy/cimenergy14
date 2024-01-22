import React, { Component } from 'react'
import PositionPointService from '../services/PositionPointService';

class UpdatePositionPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePositionPoint = this.updatePositionPoint.bind(this);

    }

    componentDidMount(){
        PositionPointService.getPositionPointById(this.state.id).then( (res) =>{
            let positionPoint = res.data;
            this.setState({
            });
        });
    }

    updatePositionPoint = (e) => {
        e.preventDefault();
        let positionPoint = {
            positionPointId: this.state.id,
        };
        console.log('positionPoint => ' + JSON.stringify(positionPoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        PositionPointService.updatePositionPoint(positionPoint).then( res => {
            this.props.history.push('/positionPoints');
        });
    }


    cancel(){
        this.props.history.push('/positionPoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PositionPoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePositionPoint}>Save</button>
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

export default UpdatePositionPointComponent

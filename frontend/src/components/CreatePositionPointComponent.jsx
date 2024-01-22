import React, { Component } from 'react'
import PositionPointService from '../services/PositionPointService';

class CreatePositionPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PositionPointService.getPositionPointById(this.state.id).then( (res) =>{
                let positionPoint = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePositionPoint = (e) => {
        e.preventDefault();
        let positionPoint = {
                positionPointId: this.state.id,
            };
        console.log('positionPoint => ' + JSON.stringify(positionPoint));

        // step 5
        if(this.state.id === '_add'){
            positionPoint.positionPointId=''
            PositionPointService.createPositionPoint(positionPoint).then(res =>{
                this.props.history.push('/positionPoints');
            });
        }else{
            PositionPointService.updatePositionPoint(positionPoint).then( res => {
                this.props.history.push('/positionPoints');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/positionPoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PositionPoint</h3>
        }else{
            return <h3 className="text-center">Update PositionPoint</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePositionPoint}>Save</button>
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

export default CreatePositionPointComponent

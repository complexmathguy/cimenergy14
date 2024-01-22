import React, { Component } from 'react'
import RegularTimePointService from '../services/RegularTimePointService';

class CreateRegularTimePointComponent extends Component {
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
            RegularTimePointService.getRegularTimePointById(this.state.id).then( (res) =>{
                let regularTimePoint = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateRegularTimePoint = (e) => {
        e.preventDefault();
        let regularTimePoint = {
                regularTimePointId: this.state.id,
            };
        console.log('regularTimePoint => ' + JSON.stringify(regularTimePoint));

        // step 5
        if(this.state.id === '_add'){
            regularTimePoint.regularTimePointId=''
            RegularTimePointService.createRegularTimePoint(regularTimePoint).then(res =>{
                this.props.history.push('/regularTimePoints');
            });
        }else{
            RegularTimePointService.updateRegularTimePoint(regularTimePoint).then( res => {
                this.props.history.push('/regularTimePoints');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/regularTimePoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RegularTimePoint</h3>
        }else{
            return <h3 className="text-center">Update RegularTimePoint</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRegularTimePoint}>Save</button>
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

export default CreateRegularTimePointComponent

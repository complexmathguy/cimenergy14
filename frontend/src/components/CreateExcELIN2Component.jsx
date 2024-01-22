import React, { Component } from 'react'
import ExcELIN2Service from '../services/ExcELIN2Service';

class CreateExcELIN2Component extends Component {
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
            ExcELIN2Service.getExcELIN2ById(this.state.id).then( (res) =>{
                let excELIN2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcELIN2 = (e) => {
        e.preventDefault();
        let excELIN2 = {
                excELIN2Id: this.state.id,
            };
        console.log('excELIN2 => ' + JSON.stringify(excELIN2));

        // step 5
        if(this.state.id === '_add'){
            excELIN2.excELIN2Id=''
            ExcELIN2Service.createExcELIN2(excELIN2).then(res =>{
                this.props.history.push('/excELIN2s');
            });
        }else{
            ExcELIN2Service.updateExcELIN2(excELIN2).then( res => {
                this.props.history.push('/excELIN2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excELIN2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcELIN2</h3>
        }else{
            return <h3 className="text-center">Update ExcELIN2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcELIN2}>Save</button>
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

export default CreateExcELIN2Component

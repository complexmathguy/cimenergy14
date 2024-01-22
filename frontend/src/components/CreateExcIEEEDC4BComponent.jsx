import React, { Component } from 'react'
import ExcIEEEDC4BService from '../services/ExcIEEEDC4BService';

class CreateExcIEEEDC4BComponent extends Component {
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
            ExcIEEEDC4BService.getExcIEEEDC4BById(this.state.id).then( (res) =>{
                let excIEEEDC4B = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEDC4B = (e) => {
        e.preventDefault();
        let excIEEEDC4B = {
                excIEEEDC4BId: this.state.id,
            };
        console.log('excIEEEDC4B => ' + JSON.stringify(excIEEEDC4B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEDC4B.excIEEEDC4BId=''
            ExcIEEEDC4BService.createExcIEEEDC4B(excIEEEDC4B).then(res =>{
                this.props.history.push('/excIEEEDC4Bs');
            });
        }else{
            ExcIEEEDC4BService.updateExcIEEEDC4B(excIEEEDC4B).then( res => {
                this.props.history.push('/excIEEEDC4Bs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEDC4Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEDC4B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEDC4B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEDC4B}>Save</button>
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

export default CreateExcIEEEDC4BComponent

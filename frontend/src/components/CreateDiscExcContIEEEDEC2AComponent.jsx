import React, { Component } from 'react'
import DiscExcContIEEEDEC2AService from '../services/DiscExcContIEEEDEC2AService';

class CreateDiscExcContIEEEDEC2AComponent extends Component {
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
            DiscExcContIEEEDEC2AService.getDiscExcContIEEEDEC2AById(this.state.id).then( (res) =>{
                let discExcContIEEEDEC2A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiscExcContIEEEDEC2A = (e) => {
        e.preventDefault();
        let discExcContIEEEDEC2A = {
                discExcContIEEEDEC2AId: this.state.id,
            };
        console.log('discExcContIEEEDEC2A => ' + JSON.stringify(discExcContIEEEDEC2A));

        // step 5
        if(this.state.id === '_add'){
            discExcContIEEEDEC2A.discExcContIEEEDEC2AId=''
            DiscExcContIEEEDEC2AService.createDiscExcContIEEEDEC2A(discExcContIEEEDEC2A).then(res =>{
                this.props.history.push('/discExcContIEEEDEC2As');
            });
        }else{
            DiscExcContIEEEDEC2AService.updateDiscExcContIEEEDEC2A(discExcContIEEEDEC2A).then( res => {
                this.props.history.push('/discExcContIEEEDEC2As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/discExcContIEEEDEC2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiscExcContIEEEDEC2A</h3>
        }else{
            return <h3 className="text-center">Update DiscExcContIEEEDEC2A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiscExcContIEEEDEC2A}>Save</button>
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

export default CreateDiscExcContIEEEDEC2AComponent

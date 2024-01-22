import React, { Component } from 'react'
import DiscExcContIEEEDEC1AService from '../services/DiscExcContIEEEDEC1AService';

class CreateDiscExcContIEEEDEC1AComponent extends Component {
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
            DiscExcContIEEEDEC1AService.getDiscExcContIEEEDEC1AById(this.state.id).then( (res) =>{
                let discExcContIEEEDEC1A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiscExcContIEEEDEC1A = (e) => {
        e.preventDefault();
        let discExcContIEEEDEC1A = {
                discExcContIEEEDEC1AId: this.state.id,
            };
        console.log('discExcContIEEEDEC1A => ' + JSON.stringify(discExcContIEEEDEC1A));

        // step 5
        if(this.state.id === '_add'){
            discExcContIEEEDEC1A.discExcContIEEEDEC1AId=''
            DiscExcContIEEEDEC1AService.createDiscExcContIEEEDEC1A(discExcContIEEEDEC1A).then(res =>{
                this.props.history.push('/discExcContIEEEDEC1As');
            });
        }else{
            DiscExcContIEEEDEC1AService.updateDiscExcContIEEEDEC1A(discExcContIEEEDEC1A).then( res => {
                this.props.history.push('/discExcContIEEEDEC1As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/discExcContIEEEDEC1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiscExcContIEEEDEC1A</h3>
        }else{
            return <h3 className="text-center">Update DiscExcContIEEEDEC1A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiscExcContIEEEDEC1A}>Save</button>
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

export default CreateDiscExcContIEEEDEC1AComponent

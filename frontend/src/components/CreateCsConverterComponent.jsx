import React, { Component } from 'react'
import CsConverterService from '../services/CsConverterService';

class CreateCsConverterComponent extends Component {
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
            CsConverterService.getCsConverterById(this.state.id).then( (res) =>{
                let csConverter = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateCsConverter = (e) => {
        e.preventDefault();
        let csConverter = {
                csConverterId: this.state.id,
            };
        console.log('csConverter => ' + JSON.stringify(csConverter));

        // step 5
        if(this.state.id === '_add'){
            csConverter.csConverterId=''
            CsConverterService.createCsConverter(csConverter).then(res =>{
                this.props.history.push('/csConverters');
            });
        }else{
            CsConverterService.updateCsConverter(csConverter).then( res => {
                this.props.history.push('/csConverters');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/csConverters');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add CsConverter</h3>
        }else{
            return <h3 className="text-center">Update CsConverter</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCsConverter}>Save</button>
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

export default CreateCsConverterComponent

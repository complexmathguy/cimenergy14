import React, { Component } from 'react'
import ACDCConverterService from '../services/ACDCConverterService';

class CreateACDCConverterComponent extends Component {
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
            ACDCConverterService.getACDCConverterById(this.state.id).then( (res) =>{
                let aCDCConverter = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateACDCConverter = (e) => {
        e.preventDefault();
        let aCDCConverter = {
                aCDCConverterId: this.state.id,
            };
        console.log('aCDCConverter => ' + JSON.stringify(aCDCConverter));

        // step 5
        if(this.state.id === '_add'){
            aCDCConverter.aCDCConverterId=''
            ACDCConverterService.createACDCConverter(aCDCConverter).then(res =>{
                this.props.history.push('/aCDCConverters');
            });
        }else{
            ACDCConverterService.updateACDCConverter(aCDCConverter).then( res => {
                this.props.history.push('/aCDCConverters');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/aCDCConverters');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ACDCConverter</h3>
        }else{
            return <h3 className="text-center">Update ACDCConverter</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateACDCConverter}>Save</button>
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

export default CreateACDCConverterComponent

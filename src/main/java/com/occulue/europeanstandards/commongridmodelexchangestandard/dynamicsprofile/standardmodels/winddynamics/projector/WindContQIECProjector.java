/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for WindContQIEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindContQIEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindContQIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windContQIEC")
@Component("windContQIEC-projector")
public class WindContQIECProjector extends WindContQIECEntityProjector {

  // core constructor
  public WindContQIECProjector(
      WindContQIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindContQIECEvent
   */
  @EventHandler(payloadType = CreateWindContQIECEvent.class)
  public void handle(CreateWindContQIECEvent event) {
    LOGGER.info("handling CreateWindContQIECEvent - " + event);
    WindContQIEC entity = new WindContQIEC();
    entity.setWindContQIECId(event.getWindContQIECId());
    entity.setWindLVRTQcontrolModesType(event.getWindLVRTQcontrolModesType());
    entity.setWindQcontrolModesType(event.getWindQcontrolModesType());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UpdateWindContQIECEvent
   */
  @EventHandler(payloadType = UpdateWindContQIECEvent.class)
  public void handle(UpdateWindContQIECEvent event) {
    LOGGER.info("handling UpdateWindContQIECEvent - " + event);

    WindContQIEC entity = new WindContQIEC();
    entity.setWindContQIECId(event.getWindContQIECId());
    entity.setIqh1(event.getIqh1());
    entity.setIqmax(event.getIqmax());
    entity.setIqmin(event.getIqmin());
    entity.setIqpost(event.getIqpost());
    entity.setKiq(event.getKiq());
    entity.setKiu(event.getKiu());
    entity.setKpq(event.getKpq());
    entity.setKpu(event.getKpu());
    entity.setKqv(event.getKqv());
    entity.setQmax(event.getQmax());
    entity.setQmin(event.getQmin());
    entity.setRdroop(event.getRdroop());
    entity.setTiq(event.getTiq());
    entity.setTpfilt(event.getTpfilt());
    entity.setTpost(event.getTpost());
    entity.setTqord(event.getTqord());
    entity.setTufilt(event.getTufilt());
    entity.setUdb1(event.getUdb1());
    entity.setUdb2(event.getUdb2());
    entity.setUmax(event.getUmax());
    entity.setUmin(event.getUmin());
    entity.setUqdip(event.getUqdip());
    entity.setUref0(event.getUref0());
    entity.setWindLVRTQcontrolModesType(event.getWindLVRTQcontrolModesType());
    entity.setWindQcontrolModesType(event.getWindQcontrolModesType());
    entity.setXdroop(event.getXdroop());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event DeleteWindContQIECEvent
   */
  @EventHandler(payloadType = DeleteWindContQIECEvent.class)
  public void handle(DeleteWindContQIECEvent event) {
    LOGGER.info("handling DeleteWindContQIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindContQIEC entity = delete(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignIqh1ToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignIqh1ToWindContQIECEvent.class)
  public void handle(AssignIqh1ToWindContQIECEvent event) {
    LOGGER.info("handling AssignIqh1ToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignIqh1(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignIqh1FromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignIqh1FromWindContQIECEvent.class)
  public void handle(UnAssignIqh1FromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignIqh1FromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignIqh1(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignIqmaxToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignIqmaxToWindContQIECEvent.class)
  public void handle(AssignIqmaxToWindContQIECEvent event) {
    LOGGER.info("handling AssignIqmaxToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignIqmax(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignIqmaxFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignIqmaxFromWindContQIECEvent.class)
  public void handle(UnAssignIqmaxFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignIqmaxFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignIqmax(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignIqminToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignIqminToWindContQIECEvent.class)
  public void handle(AssignIqminToWindContQIECEvent event) {
    LOGGER.info("handling AssignIqminToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignIqmin(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignIqminFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignIqminFromWindContQIECEvent.class)
  public void handle(UnAssignIqminFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignIqminFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignIqmin(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignIqpostToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignIqpostToWindContQIECEvent.class)
  public void handle(AssignIqpostToWindContQIECEvent event) {
    LOGGER.info("handling AssignIqpostToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignIqpost(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignIqpostFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignIqpostFromWindContQIECEvent.class)
  public void handle(UnAssignIqpostFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignIqpostFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignIqpost(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignKiqToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignKiqToWindContQIECEvent.class)
  public void handle(AssignKiqToWindContQIECEvent event) {
    LOGGER.info("handling AssignKiqToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignKiq(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignKiqFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignKiqFromWindContQIECEvent.class)
  public void handle(UnAssignKiqFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignKiqFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignKiq(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignKiuToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignKiuToWindContQIECEvent.class)
  public void handle(AssignKiuToWindContQIECEvent event) {
    LOGGER.info("handling AssignKiuToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignKiu(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignKiuFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignKiuFromWindContQIECEvent.class)
  public void handle(UnAssignKiuFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignKiuFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignKiu(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignKpqToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignKpqToWindContQIECEvent.class)
  public void handle(AssignKpqToWindContQIECEvent event) {
    LOGGER.info("handling AssignKpqToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignKpq(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignKpqFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignKpqFromWindContQIECEvent.class)
  public void handle(UnAssignKpqFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignKpqFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignKpq(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignKpuToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignKpuToWindContQIECEvent.class)
  public void handle(AssignKpuToWindContQIECEvent event) {
    LOGGER.info("handling AssignKpuToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignKpu(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignKpuFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignKpuFromWindContQIECEvent.class)
  public void handle(UnAssignKpuFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignKpuFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignKpu(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignKqvToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignKqvToWindContQIECEvent.class)
  public void handle(AssignKqvToWindContQIECEvent event) {
    LOGGER.info("handling AssignKqvToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignKqv(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignKqvFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignKqvFromWindContQIECEvent.class)
  public void handle(UnAssignKqvFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignKqvFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignKqv(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignQmaxToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignQmaxToWindContQIECEvent.class)
  public void handle(AssignQmaxToWindContQIECEvent event) {
    LOGGER.info("handling AssignQmaxToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignQmax(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignQmaxFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignQmaxFromWindContQIECEvent.class)
  public void handle(UnAssignQmaxFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignQmaxFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignQmax(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignQminToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignQminToWindContQIECEvent.class)
  public void handle(AssignQminToWindContQIECEvent event) {
    LOGGER.info("handling AssignQminToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignQmin(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignQminFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignQminFromWindContQIECEvent.class)
  public void handle(UnAssignQminFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignQminFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignQmin(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignRdroopToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignRdroopToWindContQIECEvent.class)
  public void handle(AssignRdroopToWindContQIECEvent event) {
    LOGGER.info("handling AssignRdroopToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignRdroop(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignRdroopFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignRdroopFromWindContQIECEvent.class)
  public void handle(UnAssignRdroopFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignRdroopFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignRdroop(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignTiqToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignTiqToWindContQIECEvent.class)
  public void handle(AssignTiqToWindContQIECEvent event) {
    LOGGER.info("handling AssignTiqToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignTiq(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignTiqFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignTiqFromWindContQIECEvent.class)
  public void handle(UnAssignTiqFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignTiqFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignTiq(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignTpfiltToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignTpfiltToWindContQIECEvent.class)
  public void handle(AssignTpfiltToWindContQIECEvent event) {
    LOGGER.info("handling AssignTpfiltToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignTpfilt(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignTpfiltFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignTpfiltFromWindContQIECEvent.class)
  public void handle(UnAssignTpfiltFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignTpfiltFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignTpfilt(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignTpostToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignTpostToWindContQIECEvent.class)
  public void handle(AssignTpostToWindContQIECEvent event) {
    LOGGER.info("handling AssignTpostToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignTpost(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignTpostFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignTpostFromWindContQIECEvent.class)
  public void handle(UnAssignTpostFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignTpostFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignTpost(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignTqordToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignTqordToWindContQIECEvent.class)
  public void handle(AssignTqordToWindContQIECEvent event) {
    LOGGER.info("handling AssignTqordToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignTqord(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignTqordFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignTqordFromWindContQIECEvent.class)
  public void handle(UnAssignTqordFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignTqordFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignTqord(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignTufiltToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignTufiltToWindContQIECEvent.class)
  public void handle(AssignTufiltToWindContQIECEvent event) {
    LOGGER.info("handling AssignTufiltToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignTufilt(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignTufiltFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignTufiltFromWindContQIECEvent.class)
  public void handle(UnAssignTufiltFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignTufiltFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignTufilt(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignUdb1ToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignUdb1ToWindContQIECEvent.class)
  public void handle(AssignUdb1ToWindContQIECEvent event) {
    LOGGER.info("handling AssignUdb1ToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignUdb1(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignUdb1FromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignUdb1FromWindContQIECEvent.class)
  public void handle(UnAssignUdb1FromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignUdb1FromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignUdb1(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignUdb2ToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignUdb2ToWindContQIECEvent.class)
  public void handle(AssignUdb2ToWindContQIECEvent event) {
    LOGGER.info("handling AssignUdb2ToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignUdb2(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignUdb2FromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignUdb2FromWindContQIECEvent.class)
  public void handle(UnAssignUdb2FromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignUdb2FromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignUdb2(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignUmaxToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignUmaxToWindContQIECEvent.class)
  public void handle(AssignUmaxToWindContQIECEvent event) {
    LOGGER.info("handling AssignUmaxToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignUmax(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignUmaxFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignUmaxFromWindContQIECEvent.class)
  public void handle(UnAssignUmaxFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignUmaxFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignUmax(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignUminToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignUminToWindContQIECEvent.class)
  public void handle(AssignUminToWindContQIECEvent event) {
    LOGGER.info("handling AssignUminToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignUmin(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignUminFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignUminFromWindContQIECEvent.class)
  public void handle(UnAssignUminFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignUminFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignUmin(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignUqdipToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignUqdipToWindContQIECEvent.class)
  public void handle(AssignUqdipToWindContQIECEvent event) {
    LOGGER.info("handling AssignUqdipToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignUqdip(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignUqdipFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignUqdipFromWindContQIECEvent.class)
  public void handle(UnAssignUqdipFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignUqdipFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignUqdip(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignUref0ToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignUref0ToWindContQIECEvent.class)
  public void handle(AssignUref0ToWindContQIECEvent event) {
    LOGGER.info("handling AssignUref0ToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignUref0(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignUref0FromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignUref0FromWindContQIECEvent.class)
  public void handle(UnAssignUref0FromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignUref0FromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignUref0(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event AssignXdroopToWindContQIECEvent
   */
  @EventHandler(payloadType = AssignXdroopToWindContQIECEvent.class)
  public void handle(AssignXdroopToWindContQIECEvent event) {
    LOGGER.info("handling AssignXdroopToWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContQIEC entity = assignXdroop(event.getWindContQIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /*
   * @param	event UnAssignXdroopFromWindContQIECEvent
   */
  @EventHandler(payloadType = UnAssignXdroopFromWindContQIECEvent.class)
  public void handle(UnAssignXdroopFromWindContQIECEvent event) {
    LOGGER.info("handling UnAssignXdroopFromWindContQIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContQIEC entity = unAssignXdroop(event.getWindContQIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContQIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContQIEC(entity);
  }

  /**
   * Method to retrieve the WindContQIEC via an WindContQIECPrimaryKey.
   *
   * @param id Long
   * @return WindContQIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindContQIEC handle(FindWindContQIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindContQIECId());
  }

  /**
   * Method to retrieve a collection of all WindContQIECs
   *
   * @param query FindAllWindContQIECQuery
   * @return List<WindContQIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindContQIEC> handle(FindAllWindContQIECQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindContQIEC, but only if the id matches
   *
   * @param entity WindContQIEC
   */
  protected void emitFindWindContQIEC(WindContQIEC entity) {
    LOGGER.info("handling emitFindWindContQIEC");

    queryUpdateEmitter.emit(
        FindWindContQIECQuery.class,
        query -> query.getFilter().getWindContQIECId().equals(entity.getWindContQIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindContQIEC
   *
   * @param entity WindContQIEC
   */
  protected void emitFindAllWindContQIEC(WindContQIEC entity) {
    LOGGER.info("handling emitFindAllWindContQIEC");

    queryUpdateEmitter.emit(FindAllWindContQIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(WindContQIECProjector.class.getName());
}

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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * CurveData business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of CurveData related services in the case of a CurveData business
 *       related service failing.
 *   <li>Exposes a simpler, uniform CurveData interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill CurveData business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class CurveDataBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public CurveDataBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * CurveData Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return CurveDataBusinessDelegate
   */
  public static CurveDataBusinessDelegate getCurveDataInstance() {
    return (new CurveDataBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createCurveData(CreateCurveDataCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getCurveDataId() == null) command.setCurveDataId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateCurveDataCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateCurveDataCommand of CurveData is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create CurveData - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateCurveDataCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateCurveData(UpdateCurveDataCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateCurveDataCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save CurveData - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteCurveDataCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteCurveDataCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteCurveDataCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete CurveData using Id = " + command.getCurveDataId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the CurveData via CurveDataFetchOneSummary
   *
   * @param summary CurveDataFetchOneSummary
   * @return CurveDataFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public CurveData getCurveData(CurveDataFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("CurveDataFetchOneSummary arg cannot be null");

    CurveData entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      CurveDataValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a CurveData
      // --------------------------------------
      CompletableFuture<CurveData> futureEntity =
          queryGateway.query(
              new FindCurveDataQuery(new LoadCurveDataFilter(summary.getCurveDataId())),
              ResponseTypes.instanceOf(CurveData.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate CurveData with id " + summary.getCurveDataId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all CurveDatas
   *
   * @return List<CurveData>
   * @exception ProcessingException Thrown if any problems
   */
  public List<CurveData> getAllCurveData() throws ProcessingException {
    List<CurveData> list = null;

    try {
      CompletableFuture<List<CurveData>> futureList =
          queryGateway.query(
              new FindAllCurveDataQuery(), ResponseTypes.multipleInstancesOf(CurveData.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all CurveData";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Xvalue on CurveData
   *
   * @param command AssignXvalueToCurveDataCommand
   * @exception ProcessingException
   */
  public void assignXvalue(AssignXvalueToCurveDataCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCurveDataId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    CurveDataBusinessDelegate parentDelegate = CurveDataBusinessDelegate.getCurveDataInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Xvalue on CurveData
   *
   * @param command UnAssignXvalueFromCurveDataCommand
   * @exception ProcessingException
   */
  public void unAssignXvalue(UnAssignXvalueFromCurveDataCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xvalue on CurveData";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Y1value on CurveData
   *
   * @param command AssignY1valueToCurveDataCommand
   * @exception ProcessingException
   */
  public void assignY1value(AssignY1valueToCurveDataCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCurveDataId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    CurveDataBusinessDelegate parentDelegate = CurveDataBusinessDelegate.getCurveDataInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Y1value on CurveData
   *
   * @param command UnAssignY1valueFromCurveDataCommand
   * @exception ProcessingException
   */
  public void unAssignY1value(UnAssignY1valueFromCurveDataCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Y1value on CurveData";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Y2value on CurveData
   *
   * @param command AssignY2valueToCurveDataCommand
   * @exception ProcessingException
   */
  public void assignY2value(AssignY2valueToCurveDataCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCurveDataId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    CurveDataBusinessDelegate parentDelegate = CurveDataBusinessDelegate.getCurveDataInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Y2value on CurveData
   *
   * @param command UnAssignY2valueFromCurveDataCommand
   * @exception ProcessingException
   */
  public void unAssignY2value(UnAssignY2valueFromCurveDataCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Y2value on CurveData";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add CurveData to CurveDatas
   *
   * @param command AssignCurveDatasToCurveDataCommand
   * @exception ProcessingException
   */
  public void addToCurveDatas(AssignCurveDatasToCurveDataCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getCurveDataId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .CurveDataBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.CurveDataBusinessDelegate.getCurveDataInstance();
    CurveDataBusinessDelegate parentDelegate = CurveDataBusinessDelegate.getCurveDataInstance();
    UUID childId = command.getAddTo().getCurveDataId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a CurveData as CurveDatas to CurveData";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove CurveData from CurveDatas
   *
   * @param command RemoveCurveDatasFromCurveDataCommand
   * @exception ProcessingException
   */
  public void removeFromCurveDatas(RemoveCurveDatasFromCurveDataCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.delegate
            .CurveDataBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core
                .delegate.CurveDataBusinessDelegate.getCurveDataInstance();
    UUID childId = command.getRemoveFrom().getCurveDataId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      CurveDataValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return CurveData
   */
  private CurveData load(UUID id) throws ProcessingException {
    curveData =
        CurveDataBusinessDelegate.getCurveDataInstance()
            .getCurveData(new CurveDataFetchOneSummary(id));
    return curveData;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private CurveData curveData = null;
  private static final Logger LOGGER = Logger.getLogger(CurveDataBusinessDelegate.class.getName());
}

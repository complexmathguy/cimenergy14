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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.validator.*;
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
 * ProprietaryParameterDynamics business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ProprietaryParameterDynamics related services in the case of a
 *       ProprietaryParameterDynamics business related service failing.
 *   <li>Exposes a simpler, uniform ProprietaryParameterDynamics interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       ProprietaryParameterDynamics business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ProprietaryParameterDynamicsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ProprietaryParameterDynamicsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ProprietaryParameterDynamics Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ProprietaryParameterDynamicsBusinessDelegate
   */
  public static ProprietaryParameterDynamicsBusinessDelegate
      getProprietaryParameterDynamicsInstance() {
    return (new ProprietaryParameterDynamicsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createProprietaryParameterDynamics(
      CreateProprietaryParameterDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getProprietaryParameterDynamicsId() == null)
        command.setProprietaryParameterDynamicsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateProprietaryParameterDynamicsCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateProprietaryParameterDynamicsCommand of ProprietaryParameterDynamics is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ProprietaryParameterDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateProprietaryParameterDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateProprietaryParameterDynamics(
      UpdateProprietaryParameterDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateProprietaryParameterDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ProprietaryParameterDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteProprietaryParameterDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteProprietaryParameterDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteProprietaryParameterDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ProprietaryParameterDynamics using Id = "
              + command.getProprietaryParameterDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ProprietaryParameterDynamics via
   * ProprietaryParameterDynamicsFetchOneSummary
   *
   * @param summary ProprietaryParameterDynamicsFetchOneSummary
   * @return ProprietaryParameterDynamicsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ProprietaryParameterDynamics getProprietaryParameterDynamics(
      ProprietaryParameterDynamicsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "ProprietaryParameterDynamicsFetchOneSummary arg cannot be null");

    ProprietaryParameterDynamics entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ProprietaryParameterDynamics
      // --------------------------------------
      CompletableFuture<ProprietaryParameterDynamics> futureEntity =
          queryGateway.query(
              new FindProprietaryParameterDynamicsQuery(
                  new LoadProprietaryParameterDynamicsFilter(
                      summary.getProprietaryParameterDynamicsId())),
              ResponseTypes.instanceOf(ProprietaryParameterDynamics.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ProprietaryParameterDynamics with id "
              + summary.getProprietaryParameterDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ProprietaryParameterDynamicss
   *
   * @return List<ProprietaryParameterDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ProprietaryParameterDynamics> getAllProprietaryParameterDynamics()
      throws ProcessingException {
    List<ProprietaryParameterDynamics> list = null;

    try {
      CompletableFuture<List<ProprietaryParameterDynamics>> futureList =
          queryGateway.query(
              new FindAllProprietaryParameterDynamicsQuery(),
              ResponseTypes.multipleInstancesOf(ProprietaryParameterDynamics.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ProprietaryParameterDynamics";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BooleanParameterValue on ProprietaryParameterDynamics
   *
   * @param command AssignBooleanParameterValueToProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void assignBooleanParameterValue(
      AssignBooleanParameterValueToProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getProprietaryParameterDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    ProprietaryParameterDynamicsBusinessDelegate parentDelegate =
        ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BooleanParameterValue on ProprietaryParameterDynamics
   *
   * @param command UnAssignBooleanParameterValueFromProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignBooleanParameterValue(
      UnAssignBooleanParameterValueFromProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BooleanParameterValue on ProprietaryParameterDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FloatParameterValue on ProprietaryParameterDynamics
   *
   * @param command AssignFloatParameterValueToProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void assignFloatParameterValue(
      AssignFloatParameterValueToProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getProprietaryParameterDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    ProprietaryParameterDynamicsBusinessDelegate parentDelegate =
        ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

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
   * unAssign FloatParameterValue on ProprietaryParameterDynamics
   *
   * @param command UnAssignFloatParameterValueFromProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignFloatParameterValue(
      UnAssignFloatParameterValueFromProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FloatParameterValue on ProprietaryParameterDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign IntegerParameterValue on ProprietaryParameterDynamics
   *
   * @param command AssignIntegerParameterValueToProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void assignIntegerParameterValue(
      AssignIntegerParameterValueToProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getProprietaryParameterDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    ProprietaryParameterDynamicsBusinessDelegate parentDelegate =
        ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get IntegerProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign IntegerParameterValue on ProprietaryParameterDynamics
   *
   * @param command UnAssignIntegerParameterValueFromProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignIntegerParameterValue(
      UnAssignIntegerParameterValueFromProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign IntegerParameterValue on ProprietaryParameterDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ParameterNumber on ProprietaryParameterDynamics
   *
   * @param command AssignParameterNumberToProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void assignParameterNumber(
      AssignParameterNumberToProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getProprietaryParameterDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    ProprietaryParameterDynamicsBusinessDelegate parentDelegate =
        ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get IntegerProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ParameterNumber on ProprietaryParameterDynamics
   *
   * @param command UnAssignParameterNumberFromProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignParameterNumber(
      UnAssignParameterNumberFromProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ParameterNumber on ProprietaryParameterDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add ProprietaryParameterDynamics to ProprietaryParameterDynamics
   *
   * @param command AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void addToProprietaryParameterDynamics(
      AssignProprietaryParameterDynamicsToProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getProprietaryParameterDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels
            .delegate.ProprietaryParameterDynamicsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .userdefinedmodels.delegate.ProprietaryParameterDynamicsBusinessDelegate
                .getProprietaryParameterDynamicsInstance();
    ProprietaryParameterDynamicsBusinessDelegate parentDelegate =
        ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance();
    UUID childId = command.getAddTo().getProprietaryParameterDynamicsId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a ProprietaryParameterDynamics as ProprietaryParameterDynamics to ProprietaryParameterDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove ProprietaryParameterDynamics from ProprietaryParameterDynamics
   *
   * @param command RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsCommand
   * @exception ProcessingException
   */
  public void removeFromProprietaryParameterDynamics(
      RemoveProprietaryParameterDynamicsFromProprietaryParameterDynamicsCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels
            .delegate.ProprietaryParameterDynamicsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .userdefinedmodels.delegate.ProprietaryParameterDynamicsBusinessDelegate
                .getProprietaryParameterDynamicsInstance();
    UUID childId = command.getRemoveFrom().getProprietaryParameterDynamicsId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ProprietaryParameterDynamicsValidator.getInstance().validate(command);

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
   * @return ProprietaryParameterDynamics
   */
  private ProprietaryParameterDynamics load(UUID id) throws ProcessingException {
    proprietaryParameterDynamics =
        ProprietaryParameterDynamicsBusinessDelegate.getProprietaryParameterDynamicsInstance()
            .getProprietaryParameterDynamics(new ProprietaryParameterDynamicsFetchOneSummary(id));
    return proprietaryParameterDynamics;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ProprietaryParameterDynamics proprietaryParameterDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(ProprietaryParameterDynamicsBusinessDelegate.class.getName());
}

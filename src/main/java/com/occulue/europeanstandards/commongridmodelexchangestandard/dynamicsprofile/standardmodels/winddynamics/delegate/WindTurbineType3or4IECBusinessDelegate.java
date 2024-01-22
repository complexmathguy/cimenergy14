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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
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
 * WindTurbineType3or4IEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindTurbineType3or4IEC related services in the case of a
 *       WindTurbineType3or4IEC business related service failing.
 *   <li>Exposes a simpler, uniform WindTurbineType3or4IEC interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindTurbineType3or4IEC
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindTurbineType3or4IECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindTurbineType3or4IECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindTurbineType3or4IEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindTurbineType3or4IECBusinessDelegate
   */
  public static WindTurbineType3or4IECBusinessDelegate getWindTurbineType3or4IECInstance() {
    return (new WindTurbineType3or4IECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindTurbineType3or4IEC(
      CreateWindTurbineType3or4IECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindTurbineType3or4IECId() == null)
        command.setWindTurbineType3or4IECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindTurbineType3or4IECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindTurbineType3or4IECCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindTurbineType3or4IECCommand of WindTurbineType3or4IEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindTurbineType3or4IEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindTurbineType3or4IECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindTurbineType3or4IEC(
      UpdateWindTurbineType3or4IECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindTurbineType3or4IECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindTurbineType3or4IECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindTurbineType3or4IEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindTurbineType3or4IECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindTurbineType3or4IECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindTurbineType3or4IECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindTurbineType3or4IECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindTurbineType3or4IEC using Id = "
              + command.getWindTurbineType3or4IECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindTurbineType3or4IEC via WindTurbineType3or4IECFetchOneSummary
   *
   * @param summary WindTurbineType3or4IECFetchOneSummary
   * @return WindTurbineType3or4IECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindTurbineType3or4IEC getWindTurbineType3or4IEC(
      WindTurbineType3or4IECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "WindTurbineType3or4IECFetchOneSummary arg cannot be null");

    WindTurbineType3or4IEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindTurbineType3or4IECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindTurbineType3or4IEC
      // --------------------------------------
      CompletableFuture<WindTurbineType3or4IEC> futureEntity =
          queryGateway.query(
              new FindWindTurbineType3or4IECQuery(
                  new LoadWindTurbineType3or4IECFilter(summary.getWindTurbineType3or4IECId())),
              ResponseTypes.instanceOf(WindTurbineType3or4IEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindTurbineType3or4IEC with id "
              + summary.getWindTurbineType3or4IECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindTurbineType3or4IECs
   *
   * @return List<WindTurbineType3or4IEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindTurbineType3or4IEC> getAllWindTurbineType3or4IEC() throws ProcessingException {
    List<WindTurbineType3or4IEC> list = null;

    try {
      CompletableFuture<List<WindTurbineType3or4IEC>> futureList =
          queryGateway.query(
              new FindAllWindTurbineType3or4IECQuery(),
              ResponseTypes.multipleInstancesOf(WindTurbineType3or4IEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindTurbineType3or4IEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign WindTurbineType3or4IEC on WindTurbineType3or4IEC
   *
   * @param command AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand
   * @exception ProcessingException
   */
  public void assignWindTurbineType3or4IEC(
      AssignWindTurbineType3or4IECToWindTurbineType3or4IECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindTurbineType3or4IECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .winddynamics.delegate.WindTurbineType3or4IECBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.winddynamics.delegate.WindTurbineType3or4IECBusinessDelegate
                .getWindTurbineType3or4IECInstance();
    WindTurbineType3or4IECBusinessDelegate parentDelegate =
        WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance();
    UUID childId = command.getAssignment().getWindTurbineType3or4IECId();
    WindTurbineType3or4IEC child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindTurbineType3or4IECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get WindTurbineType3or4IEC using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign WindTurbineType3or4IEC on WindTurbineType3or4IEC
   *
   * @param command UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand
   * @exception ProcessingException
   */
  public void unAssignWindTurbineType3or4IEC(
      UnAssignWindTurbineType3or4IECFromWindTurbineType3or4IECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindTurbineType3or4IECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign WindTurbineType3or4IEC on WindTurbineType3or4IEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindTurbineType3or4IEC
   */
  private WindTurbineType3or4IEC load(UUID id) throws ProcessingException {
    windTurbineType3or4IEC =
        WindTurbineType3or4IECBusinessDelegate.getWindTurbineType3or4IECInstance()
            .getWindTurbineType3or4IEC(new WindTurbineType3or4IECFetchOneSummary(id));
    return windTurbineType3or4IEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindTurbineType3or4IEC windTurbineType3or4IEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType3or4IECBusinessDelegate.class.getName());
}
